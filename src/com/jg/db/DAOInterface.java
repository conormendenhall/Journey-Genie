package com.jg.db;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jg.model.ItemFromArray;

public interface DAOInterface {
	public void makeDBConnection();
	public int addUser(String userName) throws SQLException;
	public void addItems(String item, int quantity, int userID) throws SQLException;
	public void deleteAllItemsForUser(int userID) throws SQLException;
	public ArrayList<ItemFromArray> loadEntries(String userName) throws SQLException;
}
