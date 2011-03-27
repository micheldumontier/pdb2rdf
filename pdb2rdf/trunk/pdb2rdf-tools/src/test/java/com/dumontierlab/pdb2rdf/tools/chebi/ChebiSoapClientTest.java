package com.dumontierlab.pdb2rdf.tools.chebi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ChebiSoapClientTest {
	@Test
	public void testOne(){
		ChebiSoapClient csc = new ChebiSoapClient();
		String anId = csc.getChebiId("Water");
		assertEquals("CHEBI:15377", anId);
	}
}
