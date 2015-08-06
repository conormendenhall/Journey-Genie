package servlets;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOPostGres {

	private static Connection dbConnection;

	public static void makeDBConnection() {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/journeyGenie", "postgres",
					"sesame");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		dbConnection = connection;
	}
	
	public static int addUser(String userName)
	{
		try{
			makeDBConnection();
			int userId = findDuplicate(userName);
			if(userId == 0)
			{
			Statement s = dbConnection.createStatement();
			String sql = "INSERT INTO users(userName) values('" + userName + "')";
			int rowCount = s.executeUpdate(sql);
			String sql2 = "SELECT userid FROM users WHERE username='" + userName + "'";
			Statement s2 = dbConnection.createStatement();
			ResultSet r = s.executeQuery(sql2);
			while(r.next())
			{
				return r.getInt(1);
			}	
			return 0;
			}
			else{
				deleteEntries(userId);
				return userId;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
		/*
		 * try { Connection c = MySqlConnection.getConnection(); Statement s =
		 * c.createStatement(); for(int i = 1; i <= 100; i++) { Movie m =
		 * MovieIO.getMovie(i); String string =
		 * "INSERT INTO movie (MovieTitle, Genre) VALUES ('" + m.getTitle() +
		 * "', '" + m.getCategory() + "')"; int rowCount =
		 * s.executeUpdate(string); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		
		
		/*
		ArrayList<String> genres = new ArrayList<String>();
		Connection c = MySqlConnection.getConnection();
		String sql = "SELECT DISTINCT Genre FROM movie";
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery(sql);
		while (r.next()) {
			genres.add(r.getString(1));
		}
		System.out.println(genres);
		request.setAttribute("genres", genres);
		*/
	}
	
	private static int findDuplicate(String userName) throws SQLException
	{
		String sql = "SELECT userid FROM users WHERE username='" + userName + "'";
		Statement s = dbConnection.createStatement();
		ResultSet r = s.executeQuery(sql);
		if(r.next())
			return r.getInt(1);
		else
			return 0;
	}
	
	public static void addItems(String item, int quantity, int userID) throws SQLException {
		Statement s = dbConnection.createStatement();
		String sql = "INSERT INTO \"itemsList\"(item, quantity, \"userID\") VALUES ('" + item + "'," + quantity + "," + userID + ")";
		int rowCount = s.executeUpdate(sql);
	}
	public static void closeConnection() throws SQLException
	{
		dbConnection.close();
	}
	

	public static void deleteEntries(int userID) throws SQLException {
		Statement s = dbConnection.createStatement();
		String sql = "DELETE FROM \"itemsList\" USING \"users\" WHERE userid ="  + userID;
		int rowCount = s.executeUpdate(sql);
	}
}


