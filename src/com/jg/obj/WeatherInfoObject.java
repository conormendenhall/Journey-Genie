package com.jg.obj;

public class WeatherInfoObject {
	public int cod;
	public double message;
	public CityObject city;
	public int cnt;
	public ListObject[] list = { new ListObject() };

	public WeatherInfoObject() {

	}

	@Override
	public boolean equals(Object obj) {
		WeatherInfoObject weatherInfoObject = (WeatherInfoObject) obj;
		return this.cod == weatherInfoObject.cod && this.message == weatherInfoObject.message
				&& this.city == weatherInfoObject.city && this.cnt == weatherInfoObject.cnt
				&& this.list == weatherInfoObject.list;
	}

}