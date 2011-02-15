/**
 * Copyright (c) 2011 Alexander De Leon Battista
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
package com.dumontierlab.pdb2rdf.tools.rdf;

import java.io.File;
import java.io.OutputStream;

import com.dumontierlab.pdb2rdf.parser.vocabulary.uri.Bio2RdfPdbUriPattern;
import com.dumontierlab.pdb2rdf.parser.vocabulary.uri.UriBuilder;
import com.dumontierlab.pdb2rdf.tools.bin.Pdb2RdfUnknownResidueParser;
import com.dumontierlab.pdb2rdf.tools.chebi.ChebiService;
import com.dumontierlab.pdb2rdf.util.UriUtil;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

/**
 * @author Alexander De Leon
 */
public class RedidueTypesOntologyGenerator {

	public static void generateResidueTypesOntology(File typesLog, OutputStream out) {
		OntModel ontology = ModelFactory.createOntologyModel();
		UriBuilder builder = new UriBuilder();
		Pdb2RdfUnknownResidueParser parser = new Pdb2RdfUnknownResidueParser(typesLog);
		ChebiService chebiService = new ChebiService();
		for (String residueType : parser.getCleanUnkownResidues()) {
			OntClass c = ontology.createClass(builder.buildUri(Bio2RdfPdbUriPattern.RESIDUE_TYPE,
					UriUtil.hash(residueType)));
			c.setLabel(residueType, null);

			String chebiId = chebiService.getChebiId(residueType);
			if (chebiId != null) {
				c.setEquivalentClass(ontology.getResource(builder.buildUri(Bio2RdfPdbUriPattern.CHEBI, chebiId)));
			} else {
				System.err.println("No chebiId for " + residueType);
			}
		}

		ontology.write(out);
	}

	public static void main(String[] args) {
		generateResidueTypesOntology(new File("/tmp/all-unknown_residues.log"), System.out);
	}

}
