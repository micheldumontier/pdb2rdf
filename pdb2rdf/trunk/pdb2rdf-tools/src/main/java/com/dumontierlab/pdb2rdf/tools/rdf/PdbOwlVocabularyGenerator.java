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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.dumontierlab.pdb2rdf.tools.bin.Pdb2RdfUnknownResidueParser;
import com.dumontierlab.pdb2rdf.util.UriUtil;
import com.hp.hpl.jena.graph.impl.Fragments.GetSlot;

/**
 * @author Alexander De Leon
 * @author Jose Cruz-Toledo
 */
public class PdbOwlVocabularyGenerator {

	
	
	static HashMap <String,String > residueMap;
	
	
	
	public PdbOwlVocabularyGenerator(){
		
	}
	
	public PdbOwlVocabularyGenerator(File aFile){
		this();
		residueMap = getResidueMap(aFile);
		
	}
	
	public static HashMap<String, String> getResidueMap(File aFile){
		Pdb2RdfUnknownResidueParser p = new Pdb2RdfUnknownResidueParser();
		HashMap<String, String> missingEntries = p.cleanUnknownResidues(new File("/tmp/input.txt"));
		Iterator<String> it = missingEntries.keySet().iterator();
		HashMap<String,String> x = new HashMap<String, String>();
		
		while(it.hasNext()){
			String k = it.next();
			String encodeme = UriUtil.replacePrimes(UriUtil.toCamelCase(k));
			String hash = UriUtil.makeHash(encodeme);
			x.put("v"+hash, k);
		}
		return x;
	}
	
	public static void createResidues(HashMap<String, String> hm){
		Iterator <String> it = hm.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			String val = hm.get(key);
			
		}
	}
	
	public static void createResiduePdbOwlVocabularyLine(String residueName) {
		
	}

	public static void createResidueResidueTableLine(String residueName) {

	}

	
}
