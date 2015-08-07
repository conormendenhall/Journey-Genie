package com.jg.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOPostGres {

	// MAKE THIS INTO A SINGLETON!

	private static Connection dbConnection;

	public static void makeDBConnection() {
		System.out.println("-------- PostgreSQL " + "JDBC Connection Testing ------------");

		try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		try {
			dbConnection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/journeyGenie", "postgres",
					"sesame");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (dbConnection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	public static int addUser(String userName) throws SQLException {
		try {
			makeDBConnection();
			int userId = findDuplicate(userName);
			if (userId == 0) {
				Statement s = dbConnection.createStatement();
				String sql = "INSERT INTO users(userName) values('" + userName + "')";
				int rowCount = s.executeUpdate(sql);
				String sql2 = "SELECT userid FROM users WHERE username='" + userName + "'";
				ResultSet r = s.executeQuery(sql2);
				while (r.next()) {
					dbConnection.close();
					return r.getInt(1);
				}
				dbConnection.close();
				return 0;
			} else {
				deleteEntries(userId);
				dbConnection.close();
				return userId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbConnection.close();
		return 0;
	}

	private static int findDuplicate(String userName) throws SQLException {
		String sql = "SELECT userid FROM users WHERE username='" + userName + "'";
		Statement s = dbConnection.createStatement();
		ResultSet r = s.executeQuery(sql);
		if (r.next())
			return r.getInt(1);
		else
			return 0;
	}

	public static void addItems(String item, int quantity, int userID) throws SQLException {
		makeDBConnection();
		Statement s = dbConnection.createStatement();
		String sql = "INSERT INTO \"itemsList\"(item, quantity, \"userID\") VALUES ('" + item + "'," + quantity + ","
				+ userID + ")";
		int rowCount = s.executeUpdate(sql);
		dbConnection.close();
	}

	// get rid of this method. close connection at end of each method.
	public static void closeConnection() throws SQLException {
		dbConnection.close();
	}

	public static void deleteEntries(int userID) throws SQLException {
		makeDBConnection();
		Statement s = dbConnection.createStatement();
		String sql = "DELETE FROM \"itemsList\" USING \"users\" WHERE userid =" + userID;
		int rowCount = s.executeUpdate(sql);
		dbConnection.close();
	}
	
	public static ArrayList<ItemFromArray> loadEntries(String userName) throws SQLException
	{
		makeDBConnection();
		ArrayList items = new ArrayList<ItemFromArray>();
		int userId = findDuplicate(userName);
		String sql2 = "SELECT item, quantity FROM \"itemsList\" WHERE \"userID\"=" + userId;
		Statement s2 = dbConnection.createStatement();
		ResultSet r = s2.executeQuery(sql2);
		while (r.next()) {
			ItemFromArray a = new ItemFromArray();
			a.setName(r.getString(1));
			a.setQuantity(r.getInt(2));
			items.add(a);
		}
		dbConnection.close();
		return items;
	}
}
