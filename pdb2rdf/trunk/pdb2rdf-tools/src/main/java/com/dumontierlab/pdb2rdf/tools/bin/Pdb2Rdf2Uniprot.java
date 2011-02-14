/**
 * This class maps a given pdb id to a uniprot id by using uniprot's rest service
 */
package com.dumontierlab.pdb2rdf.tools.bin;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.List;


import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * @author "Jose Cruz-Toledo"
 *
 */
public class Pdb2Rdf2Uniprot {
	
	String uniprotId;
	String pdbId;
	
	Model uniprotModel;
	List<URL> goMappings; 
	

	
	public Pdb2Rdf2Uniprot(String aPdbId){
		pdbId = aPdbId;
		uniprotId = "";
		uniprotModel = getUniprotModel();
		goMappings = getGoMappings(uniprotModel);
	}
	
	private List<URL> getGoMappings(Model aUpModel) {
		QueryExecution ex = QueryExecutionFactory.create("SELECT ?x ?y ?z ", aUpModel);
		ResultSet rs = ex.execSelect();
		while(rs.hasNext()){
			QuerySolution sol = rs.next();
			Resource r = sol.getResource("x");
			System.out.println(r.getURI());
		}
		
		
		return null;
	}

	/**
	 * Retrieves an RDF representation of the Uniprot mapping
	 * @return
	 */
	public Model getUniprotModel(){
		Model returnMe;
		String baseURL = "http://http://www.uniprot.org/uniprot/?query=%22pdb:\"";
		if(this.getPdbId().length() != 0){
			/*try{
			returnMe = ModelFactory.createDefaultModel();
			returnMe.read(baseURL+this.getPdbId()+"\"&format=rdf");
			return returnMe;
			}catch(UnknownHostException e){
				System.out.println(baseURL+this.getPdbId()+"\"&format=rdf");
				e.printStackTrace();
				
			}*/
		}else{
			return null;
		}
		return null;
	}

	public String getUniprotId() {
		return uniprotId;
	}

	public void setUniprotId(String uniprotId) {
		this.uniprotId = uniprotId;
	}

	public String getPdbId() {
		return pdbId;
	}

	public void setPdbId(String pdbId) {
		this.pdbId = pdbId;
	}
	
	
}
