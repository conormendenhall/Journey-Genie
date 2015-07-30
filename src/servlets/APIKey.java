package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import jSONConverterProject.WeatherInfoObject;
import jSONConverterProject.WeatherObject;
import jSONConverterProject.WeatherObjectConverter;
import travelItems.Trip;

/**
 * Servlet implementation class APIKey
 */
@WebServlet("/APIKey")
public class APIKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIKey() {
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
		String s = APIcall.callAPI(request.getParameter("cityID"), request.getParameter("countryID"));
		Trip thisTrip = new Trip();
		thisTrip.setW(WeatherObjectConverter.convert(s));
		System.out.println(thisTrip.getW().cod);
		System.out.println(thisTrip.getW().list[1].temp.day);
		PrintWriter out = response.getWriter();
		JSONObject obj = (JSONObject) JSONValue.parse(s);
		out.print(s);
	}
	

}
