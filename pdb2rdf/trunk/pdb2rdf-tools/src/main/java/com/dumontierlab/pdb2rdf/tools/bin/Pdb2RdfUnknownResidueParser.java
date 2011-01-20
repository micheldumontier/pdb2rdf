/**
 * Parse the unknown_residue.log from the output of Pdb2RDF
 * Generates a HashMap with a unique set of residue names
 */
package com.dumontierlab.pdb2rdf.tools.bin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

/**
 * @author Jose Cruz-Toledo 
 *
 */
public class Pdb2RdfUnknownResidueParser {
	/**
	 * The log file with the unknown residues
	 */
	File logFile;
	
	/**
	 * Using a hashmap to keep residues unique in an easy manner :)
	 * Key: residue name,
	 * Val: residue name
	 */
	HashMap<String, String> cleanUnkownResidues;
	
	public Pdb2RdfUnknownResidueParser(){
		cleanUnkownResidues = new HashMap<String, String>();
	}
	
	public Pdb2RdfUnknownResidueParser(File aFile){
		this();
		logFile = aFile;
		cleanUnkownResidues = cleanUnknownResidues(aFile);
	}
	
	
	/**
	 * Populate the HashMap with the unique unknown residues
	 * @param aFile
	 * @return
	 */
	public HashMap<String, String> cleanUnknownResidues(File aFile){
		HashMap<String, String> returnMe = new HashMap<String, String>();
		try {
			List<String> lines = FileUtils.readLines(aFile);
			Iterator<String> itr = lines.iterator();
			while(itr.hasNext()){
				
				String aLine = itr.next();
				String linePattern = ".*type:\\s+(.*)";
				Pattern lPattern = Pattern.compile(linePattern);
				Matcher matches = lPattern.matcher(aLine);
				if(matches.matches()){
					returnMe.put(matches.group(1), matches.group(1));
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnMe;
	}

	/**
	 * @return the logFile
	 */
	public File getLogFile() {
		return logFile;
	}

	/**
	 * @param logFile the logFile to set
	 */
	public void setLogFile(File logFile) {
		this.logFile = logFile;
	}

	/**
	 * @return the cleanUnkownResidues
	 */
	public HashMap<String, String> getCleanUnkownResidues() {
		return cleanUnkownResidues;
	}

	/**
	 * @param cleanUnkownResidues the cleanUnkownResidues to set
	 */
	public void setCleanUnkownResidues(HashMap<String, String> cleanUnkownResidues) {
		this.cleanUnkownResidues = cleanUnkownResidues;
	}
	
	
}
