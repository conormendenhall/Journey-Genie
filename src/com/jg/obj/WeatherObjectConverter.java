package com.jg.obj;

import com.google.gson.Gson;

public class WeatherObjectConverter {

	public static WeatherInfoObject convert(String string) {
		if (string == null || string.trim().equals(""))
			throw new IllegalArgumentException();
		
		Gson g = new Gson();
		WeatherInfoObject weatherInfoObject = g.fromJson(string, WeatherInfoObject.class);
		return weatherInfoObject;
	}

}
