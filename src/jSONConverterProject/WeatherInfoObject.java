package jSONConverterProject;

import java.lang.reflect.Array;

public class WeatherInfoObject {
	public int cod;
	public double message;
	public CityObject city;
	public int cnt;
	public ListObject[] list = {new ListObject()};
	
	public WeatherInfoObject()
	{
		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		WeatherInfoObject w = (WeatherInfoObject)obj;
		return
		this.cod == w.cod &&
		this.message == w.message &&
		this.city == w.city && 
		this.cnt == w.cnt &&
		this.list == w.list;
	}

}