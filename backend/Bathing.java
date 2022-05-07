package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with methods to manipulate Bathing_Facility database.
 *
 * @version 1.0 23/11/21
 *
 * @author Team05
 *
 * Copyright (c) University of Sheffield 2021
 */

public class Bathing {

	//the statement to use the query as parameter
	static PreparedStatement stmt = null;
	//result set generated by statement
	static ResultSet rs = null;
	
	/**
     * A method to add a person to the Bathing_Facility database. This works with the Properties database, if the value is false
     * it will update to true for having the facility
     *
     * @param int propertyID, the ID of the property
     * @param boolean hairDryer, if the property has a hair dryer
     * @param boolean shampoo, if the property has shampoo
     * @param boolean toiletPaper, if the property has toilet paper
     * @param boolean toilet, if the property has a toilet
     * @param boolean bath, if the property has a bath
     * @param boolean shower, if the property has a shower
     * @param boolean shareWithHost, if the property shares their bathing facility with the host
     */
	public static void addBathing(int propertyID, boolean hairDryer, boolean shampoo, boolean toiletPaper, boolean toilet, boolean bath,
			boolean shower, boolean shareWithHost) throws Exception {
		
		if (!Properties.hasBathing(propertyID)) {
			Properties.editProperty(propertyID, "hasBathing", "1");;
		} else {
			Bathing.deleteBathing(propertyID);
		}
		Connection con = DBAccess.connect();
		String query = "INSERT INTO Bathing_Facility (propertyID,hairDryer,shampoo,toiletPaper,toilet,bath,shower,shareWithHost) "
				+ "VALUES ('" + propertyID + "','" + toTinyInt(hairDryer) + "','" + toTinyInt(shampoo) + "','" + toTinyInt(toiletPaper) + "','" + toTinyInt(toilet) +
				"','" + toTinyInt(bath) + "','" + toTinyInt(shower) + "','" + toTinyInt(shareWithHost) + "')";
		//Create statement with try-catch block
		try {
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Bathing Facilities have been added to property " + propertyID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		DBAccess.disconnect();
	}
	
	/**
     * A method to edit the details of a bathing facility
     *
     * @param int property ID, the facilities property
     * @param String columnName, the feature to be updated
     * @param boolean newValue, the new value for the feature
     */
	public static void editBathing(int propertyID, String columnName, boolean newValue) {
		
		Connection con = DBAccess.connect();
		String query = "UPDATE Bathing_Facility SET " + columnName + "='" + toTinyInt(newValue) + "' WHERE propertyID ='" + propertyID + "'";
		//Create statement with try-catch block
		try {
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Property " + propertyID + "'s bathing facility details " + columnName + " has been updated to " + newValue);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBAccess.disconnect();
	
	}
	
	/**
     * A method for deleting a bathing facility according to the property ID
     *
     * @param int propertyID, the ID's property
     */
	public static void deleteBathing(int propertyID) throws Exception {
		
		Connection con = DBAccess.connect();
		String query = "DELETE FROM Bathing_Facility WHERE propertyID = '" + propertyID + "'";
		//Create statement with try-catch block
		try {
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Bathing Facilities for property " + propertyID + " deleted." );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBAccess.disconnect();
	
	}
	
	/**
     * A 'get' method for retrieving the full description of each bathing in the database
     *
     * @return List<String> toReturn, 
     */
	public static List<String> getAllBathings() {
		
		List<String> toReturn = new ArrayList<>();
		String query = "SELECT * FROM Bathing_Facility";
		Connection con = DBAccess.connect();
		//Create statement with try-catch block
		try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			//means, whilst the result has another row
			while (rs.next()) {
				int ID = rs.getInt("propertyID");
				int hairDryer = rs.getInt("hairDryer");
				int shampoo = rs.getInt("shampoo");
				int toiletPaper = rs.getInt("toiletPaper");
				int toilet = rs.getInt("toilet");
				int bath = rs.getInt("bath");
				int shower = rs.getInt("shower");
				int shareWithHost = rs.getInt("shareWithHost");
				
				String toAdd = "Bathing facilities for property " + ID + " are as follows: ";
				String refigIncluded = "";
				if (hairDryer == 1) {
					refigIncluded = "HairDryer Included";
				} else {
					refigIncluded = "HairDryer not Included";
				}
				String shampooIncluded = "";
				if (shampoo == 1) {
					shampooIncluded = "Shampoo Included";
				} else {
					shampooIncluded = "Shampoo not Included";
				}
				String toiletPaperIncluded = "";
				if (toiletPaper == 1) {
					toiletPaperIncluded = "ToiletPaper Included";
				} else {
					toiletPaperIncluded = "ToiletPaper not Included";
				}
				String toiletIncluded = "";
				if (toilet == 1) {
					toiletIncluded = "Toilet Included";
				} else {
					toiletIncluded = "Toilet not Included";
				}
				String bathIncluded = "";
				if (bath == 1) {
					bathIncluded = "Bath Included";
				} else {
					bathIncluded = "Bath not Included";
				}
				String showerIncluded = "";
				if (shower == 1) {
					showerIncluded = "Shower Included";
				} else {
					showerIncluded = "Shower not Included";
				}
				String shareWithHostIncluded = "";
				if (shareWithHost == 1) {
					shareWithHostIncluded = "ShareWithHost Included";
				} else {
					shareWithHostIncluded = "ShareWithHost not Included";
				}
				toReturn.add(toAdd+ shareWithHostIncluded + ", " + bathIncluded + ", " +
				shampooIncluded + ", " + toiletPaperIncluded + ", " + refigIncluded + ", " + toiletIncluded + ", " + showerIncluded);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		DBAccess.disconnect();
		return toReturn;
		
	}
	
	/**
     * A 'get' method for retrieving the full description a properties bathing facilities in the database
     *
     *@param propertyID, the properties ID
     * @return boolean toReturn, the string containing the description of a bathing facilities utilities
     */
	public static String getBathing(int propertyID) {
		
		String toReturn = "";
		String query = "SELECT * FROM Bathing_Facility WHERE propertyID = '" + propertyID + "'";
		Connection con = DBAccess.connect();
		//Create statement with try-catch block
		try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			//means, whilst the result has another row
			while (rs.next()) {
				int ID = rs.getInt("propertyID");
				int hairDryer = rs.getInt("hairDryer");
				int shampoo = rs.getInt("shampoo");
				int toiletPaper = rs.getInt("toiletPaper");
				int toilet = rs.getInt("toilet");
				int bath = rs.getInt("bath");
				int shower = rs.getInt("shower");
				int shareWithHost = rs.getInt("shareWithHost");
				
				String toAdd = "Bathing Facilities for property " + ID + " are as follows: ";
				String refigIncluded = "";
				if (hairDryer == 1) {
					refigIncluded = "HairDryer Included";
				} else {
					refigIncluded = "HairDryer not Included";
				}
				String shampooIncluded = "";
				if (shampoo == 1) {
					shampooIncluded = "Shampoo Included";
				} else {
					shampooIncluded = "Shampoo not Included";
				}
				String toiletPaperIncluded = "";
				if (toiletPaper == 1) {
					toiletPaperIncluded = "ToiletPaper Included";
				} else {
					toiletPaperIncluded = "ToiletPaper not Included";
				}
				String toiletIncluded = "";
				if (toilet == 1) {
					toiletIncluded = "Toilet Included";
				} else {
					toiletIncluded = "Toilet not Included";
				}
				String bathIncluded = "";
				if (bath == 1) {
					bathIncluded = "Bath Included";
				} else {
					bathIncluded = "Bath not Included";
				}
				String showerIncluded = "";
				if (shower == 1) {
					showerIncluded = "Shower Included";
				} else {
					showerIncluded = "Shower not Included";
				}
				String shareWithHostIncluded = "";
				if (shareWithHost == 1) {
					shareWithHostIncluded = "ShareWithHost Included";
				} else {
					shareWithHostIncluded = "ShareWithHost not Included";
				}
				toReturn = toAdd + shareWithHostIncluded + ", " + bathIncluded + ", " +
				shampooIncluded + ", " + toiletPaperIncluded + ", " + refigIncluded + ", " + toiletIncluded + ", " + showerIncluded;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		DBAccess.disconnect();
		return toReturn;
	}
	
	/**
     * A 'get' method for retrieving if the property has a hairDryer
     *
     * @param int propertyID, the properties specific ID
     * @return boolean toReturn, true if property has a hairDryer
     */
	public static boolean getHairDryer(int propertyID) {
		
		String query = "SELECT hairDryer FROM Bathing_Facility" + " WHERE propertyID = '" + propertyID + "'";;
		Connection con = DBAccess.connect();
		//Create statement with try-catch block
		try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			//means, whilst the result has another row
			while (rs.next()) {
				int has = rs.getInt("hairDryer");
				return Properties.toBoolean(has);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		DBAccess.disconnect();
		return false;
		
	}
	
	/**
     * A 'get' method for retrieving if the property has a shampoo
     *
     * @param int propertyID, the properties specific ID
     * @return boolean toReturn, true if property has a shampoo
     */
	public static boolean getShampoo(int propertyID) {
		
		String query = "SELECT shampoo FROM Bathing_Facility" + " WHERE propertyID = '" + propertyID + "'";;
		Connection con = DBAccess.connect();
		//Create statement with try-catch block
		try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			//means, whilst the result has another row
			while (rs.next()) {
				int has = rs.getInt("shampoo");
				return Properties.toBoolean(has);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		DBAccess.disconnect();
		return false;
		
	}
	
	/**
     * A 'get' method for retrieving if the property has an toiletPaper
     *
     * @param int propertyID, the properties specific ID
     * @return boolean toReturn, true if property has an toiletPaper
     */
	public static boolean getToiletPaper(int propertyID) {
		
		String query = "SELECT toiletPaper FROM Bathing_Facility" + " WHERE propertyID = '" + propertyID + "'";;
		Connection con = DBAccess.connect();
		//Create statement with try-catch block
		try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			//means, whilst the result has another row
			while (rs.next()) {
				int has = rs.getInt("toiletPaper");
				return Properties.toBoolean(has);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		DBAccess.disconnect();
		return false;
		
	}
	
	/**
     * A 'get' method for retrieving if the property has a toilet
     *
     * @param int propertyID, the properties specific ID
     * @return boolean toReturn, true if property has a toilet
     */
	public static boolean getToilet(int propertyID) {
		
		String query = "SELECT toilet FROM Bathing_Facility" + " WHERE propertyID = '" + propertyID + "'";;
		Connection con = DBAccess.connect();
		//Create statement with try-catch block
		try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			//means, whilst the result has another row
			while (rs.next()) {
				int has = rs.getInt("toilet");
				return Properties.toBoolean(has);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		DBAccess.disconnect();
		return false;
		
	}
	
	/**
     * A 'get' method for retrieving if the property has a bath
     *
     * @param int propertyID, the properties specific ID
     * @return boolean toReturn, true if property has a bath
     */
	public static boolean getBath(int propertyID) {
		
		String query = "SELECT bath FROM Bathing_Facility" + " WHERE propertyID = '" + propertyID + "'";;
		Connection con = DBAccess.connect();
		//Create statement with try-catch block
		try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			//means, whilst the result has another row
			while (rs.next()) {
				int has = rs.getInt("bath");
				return Properties.toBoolean(has);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		DBAccess.disconnect();
		return false;
		
	}
	
	/**
     * A 'get' method for retrieving if the property has shower
     *
     * @param int propertyID, the properties specific ID
     * @return boolean toReturn, true if property has shower
     */
	public static boolean getShower(int propertyID) {
		
		String query = "SELECT shower FROM Bathing_Facility" + " WHERE propertyID = '" + propertyID + "'";;
		Connection con = DBAccess.connect();
		//Create statement with try-catch block
		try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			//means, whilst the result has another row
			while (rs.next()) {
				int has = rs.getInt("shower");
				return Properties.toBoolean(has);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		DBAccess.disconnect();
		return false;
		
	}
	
	/**
     * A 'get' method for retrieving if the property has shareWithHost
     *
     * @param int propertyID, the properties specific ID
     * @return boolean toReturn, true if property has an shareWithHost
     */
	public static boolean getShareWithHost(int propertyID) {
		
		String query = "SELECT shareWithHost FROM Bathing_Facility" + " WHERE propertyID = '" + propertyID + "'";;
		Connection con = DBAccess.connect();
		//Create statement with try-catch block
		try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			//means, whilst the result has another row
			while (rs.next()) {
				int has = rs.getInt("shareWithHost");
				return Properties.toBoolean(has);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		DBAccess.disconnect();
		return false;
		
	}
	
	/**
     * A method to change a boolean value to a tiny int, to avoid confusion when adding properties
     *
     * @param boolean i, the boolean to be converted
     * @return toReturn, corresponding value of 1 (true) or 0 (false)
     */
	public static int toTinyInt(boolean i) throws IllegalArgumentException {
		if (!(i == true || i == false)) {throw new IllegalArgumentException("Value must be true or false");}
		int toReturn = 0;
		if (i == true) {
			return 1;
		}
		return toReturn;
	}
	
	/**
     * method to change an int to a boolean value, to avoid confusion again and to use in methods
     *
     * @param int i, to be converted
     * @return toReturn, corresponding value of true (1) or false (0)
     */
	public static boolean toBoolean(int i) throws IllegalArgumentException {
		if (!(i == 1 || i == 0)) {throw new IllegalArgumentException("Value must be 1 or 0");}
		boolean toReturn = false;
		if (i == 1) {
			return true;
		}
		return toReturn;
	}
	
}