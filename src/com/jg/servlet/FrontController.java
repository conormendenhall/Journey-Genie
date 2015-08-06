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
import com.jg.api.APICall;
import com.jg.obj.WeatherObjectConverter;
import com.jg.trip.Trip;

import servlets.ItemFromArray;
import servlets.DAOPostGres;

/**
 * Servlet implementation class APIKey
 */
@WebServlet("/APIKey")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String key = "1d81c54ec3911d8b9afa4fbae1d7ec37";
		if(request.getParameter("action").equals("add"))
		{
		String s = APICall.callAPI(request.getParameter("locationRequest"));
		Trip thisTrip = new Trip();
		thisTrip.setWeatherInfoObject(WeatherObjectConverter.convert(s));
		thisTrip.setEndDate(Integer.parseInt(request.getParameter("endDate")));
		thisTrip.setStartDate(Integer.parseInt(request.getParameter("startDate")));
		thisTrip.countEssentialQuantitySpecificItems();
		thisTrip.addNonEssentialItemsToPackingList();
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(thisTrip));
		System.out.println("Start date: " + thisTrip.getStartDate());
		System.out.println("End date: " + thisTrip.getEndDate());
		System.out.println("Min temp: " + thisTrip.getWeatherInfoObject().list[0].temp.min);
		System.out.println("Max temp: " + thisTrip.getWeatherInfoObject().list[0].temp.max);
		System.out.println("Weather code: " + thisTrip.getWeatherInfoObject().list[0].weather[0].id);
		}
		
		else if(request.getParameter("action").equals("save")) {
			int userID = DAOPostGres.addUser(request.getParameter("token"));
			Gson g = new Gson();
			ItemFromArray[] a = g.fromJson(request.getParameter("itemsArray"), ItemFromArray[].class);
			System.out.println(a[0].name);
			for (ItemFromArray itemFromArray : a) {
				try {
					DAOPostGres.addItems(itemFromArray.name, itemFromArray.quantity, userID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				DAOPostGres.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// console printout
		
		
	}
	

}
