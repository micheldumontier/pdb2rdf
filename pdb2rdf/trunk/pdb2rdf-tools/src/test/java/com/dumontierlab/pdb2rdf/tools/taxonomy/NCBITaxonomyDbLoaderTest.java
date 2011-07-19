package com.dumontierlab.pdb2rdf.tools.taxonomy;

import java.io.File;

import org.junit.Test;


public class NCBITaxonomyDbLoaderTest {
	/*@Test
	public void testingLoadingOfNames(){
		NCBITaxonomyDbLoader aLoader = new NCBITaxonomyDbLoader(new File("/home/jose/tmp/ncbi_taxdmp/names.dmp"),new File("/home/jose/tmp/ncbi_taxdmp/nodes.dmp"),new File("/home/jose/tmp/ncbi_taxdmp/citations.dmp"),new File("/home/jose/tmp/ncbi_taxdmp/division.dmp"));
		aLoader.populateNames();
	}*/
	@Test
	public void testingLoadingOfNodes(){
		NCBITaxonomyDbLoader aLoader = new NCBITaxonomyDbLoader(new File("/home/jose/tmp/ncbi_taxdmp/names.dmp"),new File("/home/jose/tmp/ncbi_taxdmp/nodes.dmp"),new File("/home/jose/tmp/ncbi_taxdmp/citations.dmp"),new File("/home/jose/tmp/ncbi_taxdmp/division.dmp"));
		aLoader.populateNodes();
	}
}
