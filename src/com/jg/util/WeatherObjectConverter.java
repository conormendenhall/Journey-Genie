package com.jg.util;

import com.google.gson.Gson;
import com.jg.model.APIData;

public class WeatherObjectConverter {

	public static APIData convert(String string) {
		if (string == null || string.trim().equals(""))
			throw new IllegalArgumentException();

		Gson g = new Gson();
		APIData data = g.fromJson(string, APIData.class);
		return data;
	}

}
