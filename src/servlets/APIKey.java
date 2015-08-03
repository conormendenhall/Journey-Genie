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

import com.google.gson.Gson;

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
		String s = APIcall.callAPI(request.getParameter("locationRequest"));
		Trip thisTrip = new Trip();
		thisTrip.setWeatherInfoObject(WeatherObjectConverter.convert(s));
		thisTrip.setEndDate(Integer.parseInt(request.getParameter("endDate")));
		thisTrip.setStartDate(Integer.parseInt(request.getParameter("startDate")));
		
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(thisTrip));
		
		// console printout
		System.out.println("Start date: " + thisTrip.getStartDate());
		System.out.println("End date: " + thisTrip.getEndDate());
		System.out.println("Min temp: " + thisTrip.getWeatherInfoObject().list[0].temp.min);
		System.out.println("Max temp: " + thisTrip.getWeatherInfoObject().list[0].temp.max);
		System.out.println("Weather code: " + thisTrip.getWeatherInfoObject().list[0].weather[0].id);
		
	}
	

}
