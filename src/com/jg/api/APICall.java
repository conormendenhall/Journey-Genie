package com.jg.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class APICall {
	public static String callAPI() throws IOException {
		return callAPI("Detroit");
	}

	public static String callAPI(String locationRequest) throws IOException {
		String apiCallURL = "http://api.openweathermap.org/data/2.5/forecast/daily?q=" + locationRequest
				+ "&mode=json&units=imperial&cnt=16";

		URL url = new URL(apiCallURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		// Buffer the result into a string
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();

		conn.disconnect();
		return sb.toString();
	}
}
