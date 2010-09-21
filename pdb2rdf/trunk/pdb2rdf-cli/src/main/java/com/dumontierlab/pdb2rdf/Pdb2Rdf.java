/**
 * Copyright (c) 2009 Dumontierlab
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.dumontierlab.pdb2rdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;
import org.openrdf.model.Resource;
import org.openrdf.model.Value;
import org.openrdf.model.impl.LiteralImpl;
import org.openrdf.model.impl.StatementImpl;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.xml.sax.InputSource;

import com.bigdata.rdf.sail.BigdataSail;
import com.bigdata.rdf.sail.BigdataSailRepository;
import com.dumontierlab.pdb2rdf.dao.VirtuosoDaoFactory;
import com.dumontierlab.pdb2rdf.model.PdbRdfModel;
import com.dumontierlab.pdb2rdf.model.VirtPdbRdfModel;
import com.dumontierlab.pdb2rdf.parser.DetailLevel;
import com.dumontierlab.pdb2rdf.parser.PdbXmlParser;
import com.dumontierlab.pdb2rdf.parser.vocabulary.PdbOwlVocabulary;
import com.dumontierlab.pdb2rdf.parser.vocabulary.uri.Bio2RdfPdbUriPattern;
import com.dumontierlab.pdb2rdf.parser.vocabulary.uri.UriBuilder;
import com.dumontierlab.pdb2rdf.util.ClusterIterator;
import com.dumontierlab.pdb2rdf.util.ConsoleProgressMonitorImpl;
import com.dumontierlab.pdb2rdf.util.DirectoryIterator;
import com.dumontierlab.pdb2rdf.util.FileIterator;
import com.dumontierlab.pdb2rdf.util.Pdb2RdfInputIterator;
import com.dumontierlab.pdb2rdf.util.PdbsIterator;
import com.dumontierlab.pdb2rdf.util.ProgressMonitor;
import com.dumontierlab.pdb2rdf.util.Statistics;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.RDFWriter;
import com.hp.hpl.jena.rdf.model.RDFWriterF;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.rdf.model.impl.RDFWriterFImpl;

/**
 * @author Alexander De Leon
 */
public class Pdb2Rdf {

	static final Logger LOG = Logger.getLogger(Pdb2Rdf.class);

	private static ThreadPoolExecutor threadPool;

	public static void main(String[] args) {

		Options options = createOptions();
		CommandLineParser parser = createCliParser();

		try {
			CommandLine cmd = parser.parse(options, args);
			if (cmd.hasOption("help")) {
				printUsage();
			} else if (cmd.hasOption("stats")) {
				printStats(cmd);
			} else if (cmd.hasOption("load")) {
				load(cmd);
			} else if (cmd.hasOption("bigdata")) {
				loadBigData(cmd);
			} else if (cmd.hasOption("ontology")) {
				printOntology();
			} else {
				printRdf(cmd);
			}

		} catch (ParseException e) {
			LOG.fatal("Unable understand your command.");
			printUsage();
			System.exit(1);
		}

	}

	private static void printStats(CommandLine cmd) {
		Pdb2RdfInputIterator i = processInput(cmd);

		Statistics statsFactory = new Statistics();
		Map<String, Double> stats = new HashMap<String, Double>();

		while (i.hasNext()) {
			InputSource input = i.next();
			PdbXmlParser parser = new PdbXmlParser();
			PdbRdfModel model = null;
			try {
				model = parser.parse(input);
				statsFactory.mergeStats(statsFactory.getStatistics(model), stats);
			} catch (Exception e) {
				String id = null;
				if (model != null) {
					id = model.getPdbId();
				}
				LOG.error("Unable to parse input for PDB: " + id, e);
			}
		}

		for (Map.Entry<String, Double> stat : stats.entrySet()) {
			System.out.println(stat.getKey() + ": " + stat.getValue());
		}

	}

	private static void printOntology() {
		PdbOwlVocabulary.getOntology().write(System.out);
	}

	private static void printRdf(final CommandLine cmd) {
		final File outDir = getOutputDirectory(cmd);
		final RDFWriter writer = getWriter(cmd);

		final ProgressMonitor monitor = getProgressMonitor();
		Pdb2RdfInputIterator i = processInput(cmd);
		final int inputSize = i.size();
		final AtomicInteger progressCount = new AtomicInteger();
		ExecutorService pool = null;
		if (outDir != null) {
			pool = getThreadPool(cmd);
		} else {
			// if output is going to the STDOUT then we need to do process in
			// sequential mode.
			pool = Executors.newSingleThreadExecutor();
		}

		final Object lock = new Object();

		while (i.hasNext()) {
			final InputSource input = i.next();
			pool.execute(new Runnable() {
				@Override
				public void run() {
					OutputStream out = System.out;
					PdbXmlParser parser = new PdbXmlParser();
					PdbRdfModel model = null;
					try {
						if (cmd.hasOption("detailLevel")) {
							try {
								DetailLevel detailLevel = Enum.valueOf(DetailLevel.class,
										cmd.getOptionValue("detailLevel"));
								model = parser.parse(input, new PdbRdfModel(), detailLevel);
							} catch (IllegalArgumentException e) {
								LOG.fatal("Invalid argument value for detailLevel option", e);
								System.exit(1);
							}
						} else {
							model = parser.parse(input, new PdbRdfModel());
						}
						if (outDir != null) {
							File directory = new File(outDir, model.getPdbId().substring(1, 3));
							synchronized (lock) {
								if (!directory.exists()) {
									directory.mkdir();
								}
							}
							File file = new File(directory, model.getPdbId() + ".rdf.gz");
							out = new GZIPOutputStream(new FileOutputStream(file));
						}
						writer.write(model, out, null);
						if (monitor != null) {
							monitor.setProgress(progressCount.incrementAndGet(), inputSize);
						}
					} catch (Exception e) {
						String id = null;
						if (model != null) {
							id = model.getPdbId();
						}
						LOG.error("Unable to parse input for PDB: " + id, e);
					} finally {
						try {
							out.close();
						} catch (IOException e) {
							LOG.error("Unable to close output stream", e);
						}
					}
				}
			});
		}
		pool.shutdown();

	}

	private static RDFWriter getWriter(CommandLine cmd) {
		RDFWriterF writerFactory = new RDFWriterFImpl();
		RDFWriter writer = writerFactory.getWriter("RDF/XML");
		if (cmd.hasOption("format")) {
			writer = writerFactory.getWriter(cmd.getOptionValue("format"));
		}
		return writer;
	}

	private static File getOutputDirectory(CommandLine cmd) {
		if (cmd.hasOption("out")) {
			File outDir = new File(cmd.getOptionValue("out"));
			if (!outDir.isDirectory()) {
				LOG.fatal("The out paramater must specify a directory");
				System.exit(1);
			}
			return outDir;
		}
		return null;
	}

	private static void load(CommandLine cmd) {
		String username = "dba";
		String password = "dba";
		String host = "localhost";
		int port = 1111;
		DetailLevel detailLevel = null;
		if (cmd.hasOption("detailLevel")) {
			try {
				detailLevel = Enum.valueOf(DetailLevel.class, cmd.getOptionValue("detailLevel"));
			} catch (IllegalArgumentException e) {
				LOG.fatal("Invalid argument value for detailLevel option", e);
				System.exit(1);
			}
		}
		final DetailLevel f_detailLevel = detailLevel;

		if (cmd.hasOption("username")) {
			username = cmd.getOptionValue("username");
		}
		if (cmd.hasOption("password")) {
			password = cmd.getOptionValue("password");
		}
		if (cmd.hasOption("host")) {
			host = cmd.getOptionValue("host");
		}
		if (cmd.hasOption("port")) {
			try {
				port = Integer.parseInt(cmd.getOptionValue("port"));
			} catch (NumberFormatException e) {
				LOG.fatal("Invalid port number: " + cmd.getOptionValue("port"));
				System.exit(1);
			}
		}

		final VirtuosoDaoFactory factory = new VirtuosoDaoFactory(host, port, username, password);
		ExecutorService pool = getThreadPool(cmd);

		final ProgressMonitor monitor = getProgressMonitor();
		final Pdb2RdfInputIterator i = processInput(cmd);
		final int inputSize = i.size();
		final AtomicInteger progressCount = new AtomicInteger();

		if (monitor != null) {
			monitor.setProgress(0, inputSize);
		}

		while (i.hasNext()) {
			final InputSource input = i.next();
			pool.execute(new Runnable() {
				public void run() {
					PdbXmlParser parser = new PdbXmlParser();
					UriBuilder uriBuilder = new UriBuilder();
					PdbRdfModel model = null;
					try {
						model = new VirtPdbRdfModel(factory, Bio2RdfPdbUriPattern.PDB_GRAPH, uriBuilder, factory
								.getTripleStoreDao());
						if (f_detailLevel != null) {
							model = parser.parse(input, new PdbRdfModel(), f_detailLevel);
						} else {
							parser.parse(input, model);
						}
						if (monitor != null) {
							monitor.setProgress(progressCount.incrementAndGet(), inputSize);
						}

					} catch (Exception e) {
						LOG.error("Uanble to parse input for pdb=" + (model != null ? model.getPdbId() : "null"), e);
					}
				}
			});
		}
		pool.shutdown();

	}

	private static void loadBigData(final CommandLine cmd) {
		DetailLevel detailLevel = null;
		if (cmd.hasOption("detailLevel")) {
			try {
				detailLevel = Enum.valueOf(DetailLevel.class, cmd.getOptionValue("detailLevel"));
			} catch (IllegalArgumentException e) {
				LOG.fatal("Invalid argument value for detailLevel option", e);
				System.exit(1);
			}
		}
		final DetailLevel f_detailLevel = detailLevel;

		String filePath = cmd.getOptionValue("bigdata");
		if (filePath == null) {
			LOG.fatal("You need to specify the path the BigData DB file");
			System.exit(1);
		}
		File journal = new File(filePath);
		if (!journal.exists()) {
			LOG.info("Creating file: " + filePath);
			try {
				journal.createNewFile();
			} catch (IOException e) {
				LOG.fatal("Unable to create file: " + filePath);
				System.exit(1);
			}
		}
		// create big data properties
		Properties properties = new Properties();
		try {
			properties.load(Pdb2Rdf.class.getResourceAsStream("/fastload.properties"));
		} catch (IOException e1) {
			LOG.warn("Unable to read bigdata configuration: /fastload.properties");
		}
		properties.setProperty(BigdataSail.Options.FILE, journal.getAbsolutePath());

		// instantiate a sail
		BigdataSail sail = new BigdataSail(properties);
		final Repository repo = new BigdataSailRepository(sail);
		try {
			repo.initialize();
		} catch (RepositoryException e) {
			LOG.fatal("Unable to initialize SAIL repository", e);
			System.exit(1);
		}

		final ExecutorService pool = getThreadPool(cmd);
		final ProgressMonitor monitor = getProgressMonitor();
		final Pdb2RdfInputIterator i = processInput(cmd);
		final int inputSize = i.size();
		final AtomicInteger progressCount = new AtomicInteger();

		while (i.hasNext()) {
			final InputSource input = i.next();
			pool.execute(new Runnable() {
				public void run() {
					PdbXmlParser parser = new PdbXmlParser();
					PdbRdfModel model = null;
					try {
						if (f_detailLevel != null) {
							model = parser.parse(input, new PdbRdfModel(), f_detailLevel);
						} else {
							model = parser.parse(input, new PdbRdfModel());
						}
						RepositoryConnection cxn = repo.getConnection();
						cxn.setAutoCommit(false);
						try {
							for (StmtIterator staments = model.listStatements(); staments.hasNext();) {
								Statement statement = staments.next();

								Resource s = new URIImpl(statement.getSubject().getURI());
								URIImpl p = new URIImpl(statement.getPredicate().getURI());
								RDFNode obj = statement.getObject();
								Value o = null;
								if (obj.isLiteral()) {
									LiteralImpl literal = null;
									if (((Literal) obj).getDatatype() != null) {
										literal = new LiteralImpl(((Literal) obj).getString(), new URIImpl(
												((Literal) obj).getDatatype().getURI()));
									} else if (((Literal) obj).getLanguage() != null
											&& ((Literal) obj).getLanguage().length() != 0) {
										literal = new LiteralImpl(((Literal) obj).getString(), ((Literal) obj)
												.getLanguage());
									} else {
										literal = new LiteralImpl(((Literal) obj).getString());
									}
									o = literal;
								} else {
									o = new URIImpl(((com.hp.hpl.jena.rdf.model.Resource) obj).getURI());
								}
								cxn.add(new StatementImpl(s, p, o));
							}
							cxn.commit();
						} catch (Exception ex) {
							cxn.rollback();
							throw ex;
						} finally {
							// close the repository connection
							cxn.close();
						}

						if (monitor != null) {
							monitor.setProgress(progressCount.incrementAndGet(), inputSize);
						}

					} catch (Exception e) {
						LOG.error("Uanble to parse input for pdb=" + (model != null ? model.getPdbId() : "null"), e);
					}
				}
			});
		}
	}

	private static ProgressMonitor getProgressMonitor() {
		try {
			return new ConsoleProgressMonitorImpl();
		} catch (IOException e) {
			LOG.warn("Unable to create progress monitor");
			return null;
		}
	}

	private static void printUsage() {
		HelpFormatter helpFormatter = new HelpFormatter();
		helpFormatter.printHelp("pdb2rdf [OPTIONS] [[PDB ID 1] [PDB ID 2] ...]", createOptions());
	}

	private static CommandLineParser createCliParser() {
		return new GnuParser();
	}

	private static Pdb2RdfInputIterator processInput(CommandLine cmd) {
		boolean gzip = cmd.hasOption("gzip");
		try {
			if (cmd.hasOption("file")) {
				File file = new File(cmd.getOptionValue("file"));
				if (!file.exists() || !file.canRead()) {
					LOG.fatal("Cannot access file: " + file);
					System.exit(1);
				}
				return new FileIterator(file, gzip);
			} else if (cmd.hasOption("dir")) {
				File dir = new File(cmd.getOptionValue("dir"));
				if (!dir.exists() || !dir.canRead() || !dir.canExecute()) {
					LOG.fatal("Cannot access directory: " + dir);
					System.exit(1);
				}
				return new DirectoryIterator(dir, gzip);
			} else if (cmd.hasOption("cluster")) {
				String url = cmd.getOptionValue("cluster");
				return new ClusterIterator(url);
			} else {
				String[] args = cmd.getArgs();
				if (args.length == 0) {
					LOG.fatal("You need to specified the file option, the dir option, or explicitly list the pdb ids.");
					printUsage();
					System.exit(1);
				}
				return new PdbsIterator(args);
			}
		} catch (Exception e) {
			LOG.fatal(e);
			System.exit(1);
			return null;
		}
	}

	@SuppressWarnings("static-access")
	private static Options createOptions() {
		Options options = new Options();
		options.addOption("load", false, "Load the resulting RDF into a Virtuoso triple store");
		Option userOption = OptionBuilder.withArgName("value").hasOptionalArgs(1)
				.withDescription("Virtuoso username (default: dba)").hasArg(true).create("username");
		options.addOption(userOption);
		Option passwordOption = OptionBuilder.withArgName("value").hasOptionalArgs(1)
				.withDescription("Virtuoso password (default: dba)").hasArg(true).create("password");
		options.addOption(passwordOption);
		Option hostOption = OptionBuilder.withArgName("value").hasOptionalArgs(1)
				.withDescription("Virtuoso host address (default: localhost)").hasArg(true).create("host");
		options.addOption(hostOption);
		Option portOption = OptionBuilder.withArgName("value").hasOptionalArgs(1)
				.withDescription("Virtuoso iSQL port number (default: 1111)").hasArg(true).create("port");
		options.addOption(portOption);
		options.addOption("help", false, "Print this message");
		Option formatOption = OptionBuilder.withArgName("RDF/XML|N-TRIPLE|N3").hasOptionalArgs(1)
				.withDescription("RDF output format (default: RDF/XMl)").hasArg(true).create("format");
		options.addOption(formatOption);
		Option dirOption = OptionBuilder.withArgName("path").withDescription("Directory where input files are located")
				.hasArg(true).create("dir");
		options.addOption(dirOption);
		Option clusterOption = OptionBuilder.withArgName("URL")
				.withDescription("URL of the cluster head where input will be acquired").hasArg(true).create("cluster");
		options.addOption(clusterOption);

		Option fileOption = OptionBuilder.withArgName("path").withDescription("Input file").hasArg(true).create("file");
		options.addOption(fileOption);
		options.addOption("gzip", false, "Input is given as gzip file(s)");
		Option outDirOption = OptionBuilder.withArgName("path")
				.withDescription("Directory where output RDF files will be created").hasArg(true).create("out");
		options.addOption(outDirOption);
		options.addOption("ontology", false, "Prints the ontology for the PDB namespace");
		Option threadsOption = OptionBuilder.withArgName("number")
				.withDescription("Number of threads (default: number of processing units * 2)").hasArg(true)
				.create("threads");
		options.addOption(threadsOption);
		Option bigdataOption = OptionBuilder.withArgName("DB path")
				.withDescription("Load the triples into a BigData journal file.").hasArg(true).create("bigdata");
		options.addOption(bigdataOption);
		options.addOption("stats", false, "Print statistics only");
		Option noAtomSitesOption = OptionBuilder.hasArg(true)
				.withDescription("Specify detail level: COMPLETE | ATOM | RESIDUE | EXPERIMENT | METADATA ")
				.create("detailLevel");
		options.addOption(noAtomSitesOption);
		return options;
	}

	private static int getNumberOfThreads(CommandLine cmd) {
		int numberOfThreads = Runtime.getRuntime().availableProcessors();
		if (cmd.hasOption("threads")) {
			try {
				numberOfThreads = Integer.parseInt(cmd.getOptionValue("threads"));
			} catch (NumberFormatException e) {
				LOG.fatal("Invalid number of threads", e);
				System.exit(1);
			}
		}
		return numberOfThreads;
	}

	private static ExecutorService getThreadPool(CommandLine cmd) {
		// twice the number of PU
		final Object monitor = new Object();
		int numberOfThreads = getNumberOfThreads(cmd);
		LOG.info("Using " + numberOfThreads + " threads.");
		ThreadPoolExecutor pool = new ThreadPoolExecutor(numberOfThreads, numberOfThreads, 10, TimeUnit.MINUTES,
				new ArrayBlockingQueue<Runnable>(1), new RejectedExecutionHandler() {
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						synchronized (monitor) {
							try {
								monitor.wait();
							} catch (InterruptedException e) {
								Thread.currentThread().interrupt();
							}
						}
						executor.execute(r);
					}
				}) {
			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				synchronized (monitor) {
					monitor.notify();
				}
				super.afterExecute(r, t);
			}
		};
		return pool;
	}

}
