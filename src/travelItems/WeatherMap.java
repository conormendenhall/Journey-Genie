package travelItems;

public class WeatherMap {
	
	static int temp;
	static int weatherCode;
	static int extreme;
	boolean include;
	
	public static int apiWeatherCode() {
		return weatherCode;
	}
	
	public static void setWeatherCode(int wCode) {
		weatherCode = wCode;
	}
	
	public static int getTemp() {
		return temp;
	}
	public static void setTemp(int tp) {
		temp = tp;
	}

	public static int getExtreme() {
		return extreme;
	}
	
	public static void setExtreme(int e){
		extreme = e;
	}
	
}
