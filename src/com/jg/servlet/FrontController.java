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
import com.jg.db.DAOPostGres;
import com.jg.db.ItemFromArray;
import com.jg.model.Trip;
import com.jg.util.ItemSelector;
import com.jg.util.WeatherObjectConverter;

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
		// String key = "1d81c54ec3911d8b9afa4fbae1d7ec37";
		if (request.getParameter("action").equals("add")) {
			String s = OpenWeatherMapAPIClient.callAPI(request.getParameter("locationRequest"));
			Trip thisTrip = new Trip();
			thisTrip.setAPIData(WeatherObjectConverter.convert(s));
			thisTrip.setEndDate(Integer.parseInt(request.getParameter("endDate")));
			thisTrip.setStartDate(Integer.parseInt(request.getParameter("startDate")));
			ItemSelector.countEssentialQuantitySpecificItems(thisTrip);
			ItemSelector.addNonEssentialItemsToInventory(thisTrip);
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(thisTrip));
			System.out.println("Start date: " + thisTrip.getStartDate());
			System.out.println("End date: " + thisTrip.getEndDate());
			System.out.println("Min temp: " + thisTrip.getAPIData().getList()[0].getTemp().getMin());
			System.out.println("Max temp: " + thisTrip.getAPIData().getList()[0].getTemp().getMax());
			System.out.println("Weather code: " + thisTrip.getAPIData().getList()[0].getWeather()[0].getId());
		}

		else if (request.getParameter("action").equals("save")) {
			Gson g = new Gson();
			ItemFromArray[] a = g.fromJson(request.getParameter("itemsArray"), ItemFromArray[].class);
			
			for (ItemFromArray itemFromArray : a) {
				System.out.println(itemFromArray.getName());
			}
			int userID = 0;
			try {
				userID = DAOPostGres.addUser(request.getParameter("token"));
				DAOPostGres.deleteEntries(userID);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (ItemFromArray itemFromArray : a) {
				try {
					DAOPostGres.addItems(itemFromArray.getName(), itemFromArray.getQuantity(), userID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// console printout
		else if (request.getParameter("action").equals("load"))
		{
			try {
				PrintWriter out = response.getWriter();
				out.print(new Gson().toJson(DAOPostGres.loadEntries(request.getParameter("token"))));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
