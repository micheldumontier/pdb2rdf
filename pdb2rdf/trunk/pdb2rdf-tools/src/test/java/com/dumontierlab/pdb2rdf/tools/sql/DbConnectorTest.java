package com.dumontierlab.pdb2rdf.tools.sql;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class DbConnectorTest {
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
}
