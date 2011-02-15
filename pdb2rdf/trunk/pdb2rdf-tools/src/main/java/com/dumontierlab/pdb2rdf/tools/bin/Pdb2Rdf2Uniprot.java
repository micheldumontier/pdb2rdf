/**
 * This class maps a given pdb id to a uniprot id by using uniprot's rest service
 */
package com.dumontierlab.pdb2rdf.tools.bin;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	/**
	 * Uniprot Id to which the input PDB id maps to
	 */
	String uniprotId;
	/**
	 * The query PDBId
	 */
	String pdbId;
	/**
	 * The jena model created from the Uniprot record
	 */
	Model uniprotModel;
	/**
	 * A list of URLs to all of the GO mappings found in uniprot for a given PDB id
	 */
	List<URL> goMappings; 
	

	
	public Pdb2Rdf2Uniprot(String aPdbId){
		pdbId = aPdbId;
		uniprotId = "";
		uniprotModel = getUniprotModel();
		goMappings = getGoMappings(uniprotModel);
	}
	
	/**
	 * Get the mappings to GO given a Uniprot RDF model
	 * @param aUpModel a Model populated with an RDF representation of a Uniprot record
	 * @return a list of URLs to GO annotations
	 */
	private List<URL> getGoMappings(Model aUpModel) {
		QueryExecution ex = QueryExecutionFactory.create("SELECT ?z WHERE{_:x <http://purl.uniprot.org/core/classifiedWith> ?z}", aUpModel);
		ResultSet rs = ex.execSelect();
		List<URL> returnMe = new ArrayList<URL>();
		while(rs.hasNext()){
			QuerySolution sol = rs.next();
			Resource r = sol.getResource("z");
			//Check if the url is from go
			String lPattern = "http:\\/\\/purl.uniprot.org\\/go\\/\\w+";
			Pattern p = Pattern.compile(lPattern);
			Matcher m = p.matcher(r.getURI());
			if(m.matches()){
				try {
					returnMe.add(new URL(m.group()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return returnMe;
	}

	/**
	 * Retrieves an RDF representation of the Uniprot mapping
	 * @return
	 */
	public Model getUniprotModel(){
		Model returnMe;
		String baseURL = "http://www.uniprot.org/uniprot/?query=%22pdb:";
		if(this.getPdbId().length() != 0){
			returnMe = ModelFactory.createDefaultModel();
			returnMe.read(baseURL+this.getPdbId()+"\"&format=rdf");
			return returnMe;	
		}else{
			return null;
		}
	}

	/**
	 * @return the uniprotId
	 */
	public String getUniprotId() {
		return uniprotId;
	}

	/**
	 * @param uniprotId the uniprotId to set
	 */
	public void setUniprotId(String uniprotId) {
		this.uniprotId = uniprotId;
	}

	/**
	 * @return the pdbId
	 */
	public String getPdbId() {
		return pdbId;
	}

	/**
	 * @param pdbId the pdbId to set
	 */
	public void setPdbId(String pdbId) {
		this.pdbId = pdbId;
	}

	/**
	 * @return the goMappings
	 */
	public List<URL> getGoMappings() {
		return goMappings;
	}

	/**
	 * @param goMappings the goMappings to set
	 */
	public void setGoMappings(List<URL> goMappings) {
		this.goMappings = goMappings;
	}

	/**
	 * @param uniprotModel the uniprotModel to set
	 */
	public void setUniprotModel(Model uniprotModel) {
		this.uniprotModel = uniprotModel;
	}

}
