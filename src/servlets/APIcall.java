package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class APIcall {
	public static String callAPI() throws IOException
	{
		return callAPI("48170", "US");
	}	
	
	public static String callAPI(String cityID, String countryID) throws IOException
	{
		String urlStr = "http://api.openweathermap.org/data/2.5/forecast/daily?zip=" + cityID + "&units=imperial&mode=json&cnt=16";
		//String urlStr = "http://api.openweathermap.org/data/2.5/forecast/city?id=" + cityID + "&APPID=1d81c54ec3911d8b9afa4fbae1d7ec37";

		 URL url = new URL(urlStr);
		  HttpURLConnection conn =
		      (HttpURLConnection) url.openConnection();

		  if (conn.getResponseCode() != 200) {
		    throw new IOException(conn.getResponseMessage());
		  }

		  // Buffer the result into a string
		  BufferedReader rd = new BufferedReader(
		      new InputStreamReader(conn.getInputStream()));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = rd.readLine()) != null) {
		    sb.append(line);
		  }
		  rd.close();

		  conn.disconnect();
		  return sb.toString();
	}	
}
