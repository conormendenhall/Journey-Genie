package com.jg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jg.api.OpenWeatherMapAPIClient;
import com.jg.db.PostGresSingleton;
import com.jg.model.ItemFromArray;
import com.jg.model.Trip;
import com.jg.util.TripObjectAssembler;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch(request.getParameter("action"))
		{
			case "add": {
				addItems(request, response);
				break;
			}
			case "save": {
				saveItems(request);
				break;
			}
			case "load": {
				loadItems(request, response);
				break;
			}
		}
	}

	private void loadItems(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(PostGresSingleton.getInstance().loadEntries(request.getParameter("token"))));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addItems(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String s = OpenWeatherMapAPIClient.callAPI(request.getParameter("locationRequest"));
		Trip thisTrip = TripObjectAssembler.generatePackingList(request, response, s, request.getParameter("startDate"), request.getParameter("endDate"));
		displayDebugStatements(thisTrip);
	}

	private void saveItems(HttpServletRequest request) {
		PostGresSingleton dbConnection = PostGresSingleton.getInstance();
		Gson g = new Gson();
		ItemFromArray[] a = g.fromJson(request.getParameter("itemsArray"), ItemFromArray[].class);
		for (ItemFromArray itemFromArray : a) {
			System.out.println(itemFromArray.getName());
		}
		int userID = 0;
		try {
			userID = dbConnection.addUser(request.getParameter("token"));
			dbConnection.deleteAllItemsForUser(userID);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		addUsersItemsIntoDatabase(a, userID);
	}

	private void addUsersItemsIntoDatabase(ItemFromArray[] a, int userID) {
		for (ItemFromArray itemFromArray : a) {
			try {
				PostGresSingleton.getInstance().addItems(itemFromArray.getName(), itemFromArray.getQuantity(), userID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void displayDebugStatements(Trip thisTrip) {
		System.out.println("Start date: " + thisTrip.getStartDate());
		System.out.println("End date: " + thisTrip.getEndDate());
		System.out.println("Min temp: " + thisTrip.getAPIData().getList()[0].getTemp().getMin());
		System.out.println("Max temp: " + thisTrip.getAPIData().getList()[0].getTemp().getMax());
		System.out.println("Weather code: " + thisTrip.getAPIData().getList()[0].getWeather()[0].getId());
	}
}
