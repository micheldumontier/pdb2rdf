package com.dumontierlab.pdb2rdf.tools.bin;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.Test;


public class Pdb2RdfUnknownResidueParserTest {
	@Test
	public void x(){
		Pdb2RdfUnknownResidueParser p = new Pdb2RdfUnknownResidueParser();
		HashMap<String, String> missingEntries = p.cleanUnknownResidues(new File("/tmp/input.txt"));
		Iterator<String> it = missingEntries.keySet().iterator();
		while(it.hasNext()){
			String k = it.next();
			System.out.println(k);
		}
	}
}
