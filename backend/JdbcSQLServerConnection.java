package backend;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This program demonstrates how to establish database connection.
 *
 * @version 1.0 23/11/21
 *
 * @author Team05
 *
 * Copyright (c) University of Sheffield 2021
 */
public class JdbcSQLServerConnection {
 
    public static void main(String[] args) {
 
        Connection con = null;
 
        try {
 
            con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team005", "team005", "463135cd");
            if (con != null) {
                DatabaseMetaData dm = (DatabaseMetaData) con.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
