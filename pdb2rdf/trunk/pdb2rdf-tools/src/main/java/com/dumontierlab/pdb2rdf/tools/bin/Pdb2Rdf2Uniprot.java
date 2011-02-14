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

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

/**
 * @author "Jose Cruz-Toledo"
 *
 */
public class Pdb2Rdf2Uniprot {
	
	String uniprotId;
	String pdbId;
	
	Model uniprotModel;
	

	
	public Pdb2Rdf2Uniprot(String aPdbId){
		pdbId = aPdbId;
		uniprotId = "";
		uniprotModel = getUniprotModel();
	}
	
	/**
	 * Retrieves an RDF representation of the Uniprot mapping
	 * @return
	 */
	public Model getUniprotModel(){
		Model returnMe;
		URL u = null;
		InputStream is = null;
		DataInputStream dis;
		String s;
		int timeout = 10000;
		String baseURL = "http://http://www.uniprot.org/uniprot/?query=%22pdb:\"";
		if(this.getPdbId().length() != 0){
			try{
					u = new URL(baseURL+this.getPdbId()+"\"&format=rdf");
					URLConnection conn = u.openConnection();
					conn.setConnectTimeout(timeout);
					conn.setReadTimeout(timeout);
					is = conn.getInputStream();
					returnMe = ModelFactory.createDefaultModel();
					returnMe.read(is, "blah");
					is.close();
					
				
			} catch (MalformedURLException e){
				e.printStackTrace();
			} catch(SocketTimeoutException e ){
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
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
