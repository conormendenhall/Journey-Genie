package jSONConverterProject;

import com.google.gson.Gson;

public class WeatherObjectConverter {

	public static WeatherInfoObject convert(String string) {
		if (string == null || string.trim().equals(""))
			throw new IllegalArgumentException();
		Gson g = new Gson();
		WeatherInfoObject obj = g.fromJson(string, WeatherInfoObject.class);
		return obj;
	}

}
