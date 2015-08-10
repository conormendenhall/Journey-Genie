package com.jg.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jg.model.Trip;

public class TripObjectAssembler {
	public static Trip generatePackingList(HttpServletRequest request, HttpServletResponse response, String s, String startDate, String endDate)
			throws IOException {
		Trip thisTrip = new Trip();
		thisTrip.setAPIData(WeatherObjectAssembler.convert(s));
		thisTrip.setEndDate(Integer.parseInt(endDate));
		thisTrip.setStartDate(Integer.parseInt(startDate));
		ItemSelector.countEssentialQuantitySpecificItems(thisTrip);
		ItemSelector.addWeatherBasedItems(thisTrip);
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(thisTrip));
		return thisTrip;
	}
}
