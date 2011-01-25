package com.dumontierlab.pdb2rdf.tools.rdf;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.dumontierlab.pdb2rdf.util.UriUtil;


public class PdbOwlVocabularyGeneratorTest {

	/**
	 * This test will generate two text files containing the lines that need to be added to PdbOwlVocabulary.java y ResidueTable.java
	 */
	@Test
	public void testTwo(){
		PdbOwlVocabularyGenerator p = new PdbOwlVocabularyGenerator(new File("/tmp/all-unknown_residues.log"));
		p.printLines(new File("/tmp/out1.txt"), p.getPdbOwlVocabularyLines());
		p.printLines(new File("/tmp/out2.txt"), p.getResidueTableLines());
	}
}
