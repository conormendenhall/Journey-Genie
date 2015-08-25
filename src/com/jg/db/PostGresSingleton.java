package com.jg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Missing PostgreSql jdbc driver");
			e.printStackTrace();
		}

		System.out.println("PostgreSQL JDBC Driver Found!");

		try {
			dbConnection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/journeyGenie", "postgres",
					"sesame");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (dbConnection != null) {
			System.out.println("DBconnection successful");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	public int addUser(String userName) throws SQLException {
		try {
			makeDBConnection();
			int userId = findDuplicate(userName);
			if (userId == 0) {
				String sql = "INSERT INTO users(userName) values(?)";
				PreparedStatement s = dbConnection.prepareStatement(sql);
				s.setString(1, userName);
				s.executeUpdate();
				String sql2 = "SELECT userid FROM users WHERE username= ? "; // To-do: make userName the primary key
				PreparedStatement s2 = dbConnection.prepareStatement(sql2);
				s2.setString(1, userName);
				ResultSet r = s2.executeQuery();
				while (r.next()) {
					return r.getInt(1);
				}
			} else {
				return userId;
			}
		} finally {
			dbConnection.close();
		}
		return 0;
	}

	private int findDuplicate(String userName) throws SQLException {
		String sql = "SELECT userid FROM users WHERE username = ?";
		PreparedStatement s = dbConnection.prepareStatement(sql);
		s.setString(1, userName);
		ResultSet r = s.executeQuery();
		if (r.next())
			return r.getInt(1);
		else
			return 0;
	}

	public void addItems(String item, int quantity, int userID) throws SQLException {
		String sql = "INSERT INTO \"itemsList\"(item, quantity, \"userID\") VALUES (?,?,?)";
		PreparedStatement s = dbConnection.prepareStatement(sql);
		s.setString(1, item);
	    s.setInt(2, quantity);
	    s.setInt(3, userID);
		s.executeUpdate();
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

	private void deleteSQLQuery(int userID) throws SQLException {
		System.out.println(userID);
		String sql = "DELETE FROM \"itemsList\" li USING \"users\" q WHERE q.userid = li.\"userID\" AND li.\"userID\" = ?";
		PreparedStatement s = dbConnection.prepareStatement(sql);
		s.setInt(1, userID);
		s.executeUpdate();
	}
	
	public ArrayList<ItemFromArray> loadEntries(String userName) throws SQLException {
		makeDBConnection();
		ArrayList<ItemFromArray> items = new ArrayList<ItemFromArray>();
		int userId = findDuplicate(userName);
		String sql2 = "SELECT item, quantity FROM \"itemsList\" WHERE \"userID\"= ? ";
		PreparedStatement s2 = dbConnection.prepareStatement(sql2);
		s2.setInt(1, userId);
		ResultSet r = s2.executeQuery();
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
	
	public void addUsersItemsIntoDatabase(ItemFromArray[] a, int userID) throws SQLException {
		makeDBConnection();
		for (ItemFromArray itemFromArray : a) {
			try {
				addItems(itemFromArray.getName(), itemFromArray.getQuantity(), userID);
			} catch (SQLException e) {
				dbConnection.close();
				e.printStackTrace();
			}
		}
			dbConnection.close();
	}
}
