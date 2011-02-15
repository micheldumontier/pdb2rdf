/**
 * 
 */
package com.dumontierlab.pdb2rdf.external;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


/**
 * @author "Jose Cruz-Toledo"
 *
 */
public class Pdb2Rdf2UniprotTest {

	@Test
	public void testOne(){
		Pdb2Rdf2Uniprot p = new Pdb2Rdf2Uniprot("3O1W");
		List<String> l = p.getGoMappings();
		Iterator<String> itr = l.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
	@Test
	public void testTwo(){
		Pdb2Rdf2Uniprot p = new Pdb2Rdf2Uniprot("3O1W");
		List<String> l = p.getUniprotMappings();
		Iterator<String> itr = l.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}
