package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with methods to manipulate properties database.
 *
 * @version 1.0 23/11/21
 *
 * @author Team05
 *
 * Copyright (c) University of Sheffield 2021
 */

public class DBAccess {

	//the database connection
	private static Connection con = null;
	
	/**
     * This method is to be used in most backend methods. This is to connect to the database for any
     * database manipulation that may be needed.
     *
     * @return con, a connection to COM2008 team05 database.
     */
	static public Connection connect() {
		boolean connected = false;
		try {
			 
            con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team005", "team005", "463135cd");
            connected = true;
 
        } catch (SQLException ex) {
        	
        	connected = false;
        	ex.printStackTrace();
            
        }
		if (!connected) {
            System.out.println("Connection to the database failed.");
		}
		return con;
	}
	
	/**
     * This method is to be used at the end of any method where connect() is needed
     *
     */
	static public void disconnect() {
		if (con != null) {
			try {
				 
	            con.close();
	 
	        } catch (SQLException ex) {
	        	
	        	ex.printStackTrace();
	            
	        }
			con = null;
		}
	}
	
}
