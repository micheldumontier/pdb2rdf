package com.dumontierlab.pdb2rdf.tools.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.junit.Test;

import com.ibm.icu.text.SimpleDateFormat;

public class DbConnectorTest {
	/**
	 * Testing the default constructor,
	 * does a simple select statement
	 */
	@Test
	public void testDbConnector() {
		//testing the default constructor
		DbConnector db = new DbConnector();
		ResultSet rs = db.executeQuery("SELECT * FROM change_history");
		int numOfCols;
		try {
			numOfCols = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i=1;i<=numOfCols;i++){
					System.out.print(rs.getObject(i)+"\t");
				}
				System.out.println();
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Testing the non-default constructor
	 * does a simple select statement
	 */
	@Test
	public void testDbConnectorStringStringString() {
		//create a db connection then execute a simple query
		DbConnector db = new DbConnector("jdbc:mysql://localhost/pdb_updates","pdb_user", "pdb_password!");
		ResultSet rs = db.executeQuery("SELECT * FROM change_history");
		int numOfCols;
		try {
			numOfCols = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i=1;i<=numOfCols;i++){
					System.out.print(rs.getObject(i)+"\t");
				}
				System.out.println();
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * This method tests the addition of a new row to the database,
	 * after the row is added the row will be deleted
	 */
	@Test
	public void testInsertRow(){
		String pdb_id = "AAAA";
		int revision = 1;
		int new_revision = -1;
		boolean insertflag1 = false;
		boolean insertflag2 = false;
		
		//create a Db connection
		DbConnector db = new DbConnector("jdbc:mysql://localhost/pdb_updates","pdb_user", "pdb_password!");
				
		//Get the current Date
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(cal.getTime());
		/* Add the new pdb entry */
		
		//check if the pdbid is already in the database,
		String qry1 = "SELECT COUNT(*) FROM change_history a WHERE a.revision ="+revision
					 +" AND a.pdb_id='"+pdb_id+"'";
		
		//if you get an empty result then add it
		ResultSet rs = db.executeQuery(qry1);
		
		//get the number of rows in the result set
		try {
			rs.next();
			int rowCount = rs.getInt(1);
			if(rowCount == 0){
				//add the new entry
				String insertQry = "INSERT INTO change_history VALUES('"+revision
									+"','"+pdb_id+"','"+currentDate+"')";
				db.executeUpdate(insertQry);
				insertflag1 = true;
			}
			//else if you get a result then add it with a new revision
			else if(rowCount > 0){
				//get the largest revision for the input pdb_id
				String qry = "SELECT revision FROM change_history WHERE pdb_id='"
							  +pdb_id+"' AND revision=(SELECT MAX(revision) FROM change_history)";
				
				ResultSet rs2 = db.executeQuery(qry);
				rs2.next();
				int a_revision = rs2.getInt(1);
				new_revision = ++a_revision;
				
				//now we are ready to add a new entry with a new revision
				String qry3 = "INSERT INTO change_history VALUES('"+new_revision
						 	+"','"+pdb_id+"','"+currentDate+"')";
				db.executeUpdate(qry3);
				insertflag2 = true;
				rs2.close();
			}
			rs.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//finally check the insertion flags to remove any added rows
		if(insertflag1 == true){
			//then remove the inserted row by insertQry
			String deleteQry = "DELETE from change_history WHERE pdb_id='"+pdb_id+"' AND revision='"+revision+"'";
			db.executeUpdate(deleteQry);
		}
		if(insertflag2 == true){
			//then remove the inserted row by qry3
			String deleteQry = "DELETE from change_history WHERE pdb_id='"+pdb_id+"' AND revision='"+new_revision+"'";
			db.executeUpdate(deleteQry);			
		}
	}
	
	/**
	 * This method tests the querying functionality.
	 * It should only return the latest (unique) revision 
	 * given the query's revision
	 */
	@Test
	public void testQuerying(){
		
	}
}
