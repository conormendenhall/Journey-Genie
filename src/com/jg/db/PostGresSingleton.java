package com.jg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jg.model.ItemFromArray;

public class PostGresSingleton implements DAOInterface{
	private static PostGresSingleton instance = null;

	private PostGresSingleton() {
		
	}
	
	public static PostGresSingleton getInstance() {
	      if(instance == null) {
	         instance = new PostGresSingleton();
	      }
	      return instance;
	   }
	
	private static Connection dbConnection;

	public void makeDBConnection() {
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

	public int addUser(String userName) throws SQLException {
		try {
			makeDBConnection();
			int userId = findDuplicate(userName);
			if (userId == 0) {
				Statement s = dbConnection.createStatement();
				String sql = "INSERT INTO users(userName) values('" + userName + "')";
				s.executeUpdate(sql);
				String sql2 = "SELECT userid FROM users WHERE username='" + userName + "'";
				ResultSet r = s.executeQuery(sql2);
				while (r.next()) {
					dbConnection.close();
					return r.getInt(1);
				}
			} else {
				deleteAllItemsForUser(userId);
				dbConnection.close();
				return userId;
			}
		} finally {
			dbConnection.close();
		}
		return 0;
	}

	private int findDuplicate(String userName) throws SQLException {
		String sql = "SELECT userid FROM users WHERE username='" + userName + "'";
		Statement s = dbConnection.createStatement();
		ResultSet r = s.executeQuery(sql);
		if (r.next())
			return r.getInt(1);
		else
			return 0;
	}

	public void addItems(String item, int quantity, int userID) throws SQLException {
		makeDBConnection();
		Statement s = dbConnection.createStatement();
		String sql = "INSERT INTO \"itemsLi st\"(item, quantity, \"userID\") VALUES ('" + item + "'," + quantity + ","
				+ userID + ")";
		s.executeUpdate(sql);
		dbConnection.close();
	}

	public void deleteAllItemsForUser(int userID) throws SQLException {
		makeDBConnection();
		try {
			deleteSQLQuery(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnection.close();
		}
	}

	private static void deleteSQLQuery(int userID) throws SQLException {
		Statement s = dbConnection.createStatement();
		String sql = "DELETE FROM \"itemsList\" USING \"users\" WHERE userid =" + userID;
		s.executeUpdate(sql);
	}
	
	public ArrayList<ItemFromArray> loadEntries(String userName) throws SQLException {
		makeDBConnection();
		ArrayList<ItemFromArray> items = new ArrayList<ItemFromArray>();
		int userId = findDuplicate(userName);
		String sql2 = "SELECT item, quantity FROM \"itemsList\" WHERE \"userID\"=" + userId;
		Statement s2 = dbConnection.createStatement();
		ResultSet r = s2.executeQuery(sql2);
		while (r.next()) {
			items.add(createItemFromArray(r));
		}
		dbConnection.close();
		return items;
	}

	private ItemFromArray createItemFromArray(ResultSet r) throws SQLException {
		ItemFromArray a = new ItemFromArray();
		a.setName(r.getString(1));
		a.setQuantity(r.getInt(2));
		return a;
	}
}
