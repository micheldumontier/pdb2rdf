/**
 * 
 */
package com.dumontierlab.pdb2rdf.tools.bin;

import com.dumontierlab.pdb2rdf.tools.rsync.RsyncParser;
import com.dumontierlab.pdb2rdf.tools.rsync.RunRsync;
import com.dumontierlab.pdb2rdf.tools.sql.DbConnector;

/**
 * @author Jose Cruz-Toledo
 *
 */
public class Pdb2RdfUpdateLogger {
	DbConnector db;
	RsyncParser rsyncParser;
	RunRsync rsyncRunner;
	
	public Pdb2RdfUpdateLogger(){
		//initialize everything
		db = new DbConnector();
		rsyncRunner = new RunRsync();
		rsyncParser = new RsyncParser();
	}
	
	
}
