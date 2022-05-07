package backend;
import java.sql.*;
import java.util.*;

/**
 * Class to check if team members have jdbc drivers installed correctly.
 *
 * @version 1.0 23/11/21
 *
 * @author Team05
 *
 * Copyright (c) University of Sheffield 2021
 */

public class FindDrivers {

	public static void main(String[] args) throws Exception {
		System.out.println("\nDrivers loaded as properties:");
		System.out.println(System.getProperty("jdbc.drivers"));
		System.out.println("\nDrivers loaded by DriverManager:");
		Enumeration<Driver> list = DriverManager.getDrivers();
		while (list.hasMoreElements()) {
			System.out.println(list.nextElement());
		}
	}
	
}

