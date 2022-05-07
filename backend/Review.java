package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import net.proteanit.sql.DbUtils;


/**
 * Class with methods to manipulate properties database.
 *
 * @version 1.0 23/11/21
 *
 * @author Team05
 *
 * Copyright (c) University of Sheffield 2021
 */

public class Review {

	//the statement to use the query as parameter
	static PreparedStatement stmt = null;
	//result set generated by statement
	static ResultSet rs = null;
	
	/**
     * A 'get' method for a hosts result set in properties
     *
     * @param int hostID, the hosts specific ID
     * @return ResultSet rs, the result set containing the hosts properties info
     */
	public static ResultSet getPropertyReviews() {
		
		//String query = "SELECT review,cleanlinessScore,communicationScore,accuracyScore,locationScore,valueScore FROM Review" + " WHERE propertyID = '" + propertyID + "'";
		String query = "SELECT propertyID,review,cleanlinessScore,communicationScore,accuracyScore,locationScore,valueScore FROM Review";
		Connection con = DBAccess.connect();
        try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			return rs;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rs;
	}
	
	
	
	/**
     * A method to return all the reviews of a certain property in a list
     * @param propertyID, the PK
     * @return a list of reviews for the property
     */
	public static List<String> getReviews(int propertyID) {
		
		String query = "SELECT * FROM Review WHERE propertyID ='" + propertyID + "'";
		Connection con = DBAccess.connect();
		List<String> toReturn = new ArrayList<>();
		//Create statement with try-catch block
		try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			String columns[] = { "PropertyID", "Review", "Cleanliness", "Communication", "Accurasy", "Location", "Value" };
			String data[][] = new String[10][7];
			int i = 0;
			//means, whilst the result has another row
			while (rs.next()) {
				String review = rs.getString("review");
				int cleanScore = rs.getInt("cleanlinessScore");
				int commScore = rs.getInt("communicationScore");
				int accScore = rs.getInt("accuracyScore");
				int locoScore = rs.getInt("locationScore");
				int valScore = rs.getInt("valueScore");
		        data[i][0] = review + "";
		        data[i][1] = cleanScore + "";
		        data[i][2] = commScore + "";
		        data[i][3] = accScore + "";
		        data[i][4] = locoScore + "";
		        data[i][5] = valScore + "";
		        i++;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		DBAccess.disconnect();
		return toReturn;
	}
	
	/**
     * A method to return an int for the average review score
     * @param propertyID, the PK
     * @return int toReturn, an int for the average review score.
     */
	public static int getAverageReviews(int propertyID) {
		
		String query = "SELECT * FROM Review WHERE propertyID ='" + propertyID + "'";
		Connection con = DBAccess.connect();
		int toReturn = 0;
		//Create statement with try-catch block
		try  {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			int i = 0;
			//means, whilst the result has another row
			while (rs.next()) {
				i++;
				int cleanScore = rs.getInt("cleanlinessScore");
				int commScore = rs.getInt("communicationScore");
				int accScore = rs.getInt("accuracyScore");
				int locoScore = rs.getInt("locationScore");
				int valScore = rs.getInt("valueScore");
		        toReturn = (int) (toReturn + (cleanScore + commScore + accScore + locoScore + valScore)/5)/i;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		DBAccess.disconnect();
		return toReturn;
	}
	
	/**
     * A method to add a review to a certain property
     *
     * @param int propertyID, the propertys PK
     * @param String review, the notes left on the review
     * @param int cleanScore, the cleanliness score
     * @param int commScore, the communication score
     * @param int accScore, the accuracy score
     * @param int locoScore, the location score
     * @param int valScore, the value score
     */
	public static void addReview(int propertyID, String review, int cleanScore, int commScore, int accScore, int locoScore, int valScore) throws Exception {
		
		if (!(Properties.propertyExists(propertyID))) {
			throw new IllegalArgumentException("This property does not exist.");
		} else {
			Connection con = DBAccess.connect();
			String query = "INSERT INTO Review (propertyID,review,cleanlinessScore,communicationScore,accuracyScore,locationScore,valueScore) "
					+ "VALUES ('" + propertyID + "','" + review + "','" + cleanScore + "','" + commScore + "','" + accScore + "','" + locoScore + "','" + valScore + "')";
			//Create statement with try-catch block
			try {
				stmt = con.prepareStatement(query);
				stmt.executeUpdate();
				System.out.println("Review added to property " + propertyID);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			DBAccess.disconnect();
		}
	}
	
	public static void deleteReviews(int propertyID ) throws Exception {
		
		Connection con = DBAccess.connect();
		String query = "DELETE FROM Review WHERE propertyID = '" + propertyID + "'";
		//Create statement with try-catch block
		try {
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Reviews for " + propertyID + " have been deleted." );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBAccess.disconnect();
	
	}
		
	//This main method is just to demonstrate how everything works :)
	public static void main(String[] args) throws Exception {
		System.out.print(getAverageReviews(16));
	}
	
}