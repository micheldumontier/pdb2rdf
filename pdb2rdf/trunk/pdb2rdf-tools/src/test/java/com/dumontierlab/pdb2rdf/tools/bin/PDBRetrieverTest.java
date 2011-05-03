/**
 * Copyright (c) 2011 Jose Miguel Cruz Toledo
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
package com.dumontierlab.pdb2rdf.tools.bin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * @author "Jose Cruz-Toledo"
 * 
 */
public class PDBRetrieverTest {

	/*
	 * @Test public void testThree(){ PDBRetriever r = new
	 * PDBRetriever("nucleic acid"); List<File> files = r.getPDBRDFPaths(new
	 * File("/media/shelf/pdb/rdf/nocoord_all/")); r.copyFiles(files, new
	 * File("/tmp/testNA/"));
	 * 
	 * }
	 * 
	 * @Test public void testFour(){ PDBRetriever r = new
	 * PDBRetriever("nucleic acid"); List<File> files = r.getPDBXMLPaths(new
	 * File("/media/shelf/pdb/xml/")); r.copyFiles(files, new
	 * File("/tmp/xmlNa")); }

	@Test
	public void testFive() {
		PDBRetriever r = new PDBRetriever("nucleic acid");
		List<File> files = r.getPDBPaths(new File("/media/shelf/pdb/pdb/"));
		r.copyFiles(files, new File("/media/shelf/NucleicAcidFun/xray/na"));
	}
	 */
	@Test
	public void testFivep2() {
		PDBRetriever r = new PDBRetriever("nucleic acid xray");
		List<File> files = r.getPDBPaths(new File("/media/shelf/pdb/pdb/"));
		r.copyFiles(files, new File("/media/shelf/NucleicAcidFun/xray/na"));
	}
	
	@Test
	public void testSix() {
		PDBRetriever r = new PDBRetriever("nucleic acid high res");
		List<File> files = r.getPDBPaths(new File("/media/shelf/pdb/pdb/"));
		r.copyFiles(files, new File("/media/shelf/NucleicAcidFun/xray/nahr"));
	}
	
	@Test
	public void testSixp2() {
		PDBRetriever r = new PDBRetriever("dna xray");
		List<File> files = r.getPDBPaths(new File("/media/shelf/pdb/pdb/"));
		r.copyFiles(files, new File("/media/shelf/NucleicAcidFun/xray/dna"));
	}
	
	@Test
	public void testSixp3() {
		PDBRetriever r = new PDBRetriever("dna high res");
		List<File> files = r.getPDBPaths(new File("/media/shelf/pdb/pdb/"));
		r.copyFiles(files, new File("/media/shelf/NucleicAcidFun/xray/dnahr"));
	}
	
	@Test
	public void testSixp4() {
		PDBRetriever r = new PDBRetriever("rna xray");
		List<File> files = r.getPDBPaths(new File("/media/shelf/pdb/pdb/"));
		r.copyFiles(files, new File("/media/shelf/NucleicAcidFun/xray/rna"));
	}
	
	@Test
	public void testSixp5() {
		PDBRetriever r = new PDBRetriever("rna high res");
		List<File> files = r.getPDBPaths(new File("/media/shelf/pdb/pdb/"));
		r.copyFiles(files, new File("/media/shelf/NucleicAcidFun/xray/rnahr"));
	}
	
	@Test
	public void testSixp6() {
		PDBRetriever r = new PDBRetriever("rna super high res");
		List<File> files = r.getPDBPaths(new File("/media/shelf/pdb/pdb/"));
		r.copyFiles(files, new File("/media/shelf/NucleicAcidFun/xray/rnashr"));
	}
	
	@Test
	public void testSixp7() {
		PDBRetriever r = new PDBRetriever("dna super high res");
		List<File> files = r.getPDBPaths(new File("/media/shelf/pdb/pdb/"));
		r.copyFiles(files, new File("/media/shelf/NucleicAcidFun/xray/dnashr"));
	}
	
	@Test
	public void testSixp8() {
		PDBRetriever r = new PDBRetriever("na super high res");
		List<File> files = r.getPDBPaths(new File("/media/shelf/pdb/pdb/"));
		r.copyFiles(files, new File("/media/shelf/NucleicAcidFun/xray/nashr"));
	}
}
