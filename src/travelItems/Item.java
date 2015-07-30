package travelItems;

public class Item {

	String name;
	int maxTemp;
	int minTemp;
	int weatherCode;
	public boolean include;
	

	public Item(String name, int minTemp, int maxTemp, int weatherCode, boolean include) {
		super();
		this.name = name;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.weatherCode = weatherCode;
		this.include = include;
		
		//return "\"" + name + "\"" +  ", " + "\"" +  minTemp + "\"" +  ", " + "\"" + maxTemp + "\"" +  ", " + "\"" +  weatherCode + "\"" +  ", " + "\"" + essentialItem + "\"" +  ", " + "\"" +  include + "\"";
	}


	public void includes() {
		
		//this will account for items needed when raining
		if (WeatherMap.getWeatherCode() < 600 && WeatherMap.getWeatherCode() > 0 && weatherCode < 600 && weatherCode > 0 ){
			include = true;
		}
		//this will account for items needed for sunny days
		else if (weatherCode >=800 && weatherCode < 900 && WeatherMap.getWeatherCode()/100 == weatherCode/100 && WeatherMap.getWeatherCode() % 10 <= weatherCode % 10){
			include = true;
		}
		//this will account for items needed for snow days
		else if (WeatherMap.getWeatherCode() >= 600 && WeatherMap.getWeatherCode() < 700 && WeatherMap.getWeatherCode() / 100 == weatherCode / 100){
			include = true;
		}
		//this will account for items needed for cold days
		else if ( maxTemp > 0 && WeatherMap.getTemp() <= maxTemp){
			include = true;}
		
		//this will account for items need for hot days
		else if ( minTemp > 0 && WeatherMap.getTemp() >= minTemp){
			include = true;}
		
		//this will account for items needed for extreme hot days
		else if (WeatherMap.getExtreme() == 904 && weatherCode == WeatherMap.getExtreme()){
			include = true;}
		
		//this will account for items needed for extreme cold days
		else if (WeatherMap.getWeatherCode() == 903 && weatherCode == WeatherMap.getWeatherCode()){
			include = true;}
		
		//this will account for items needed for windy days
		
		else {include = false;}
	}

	
}


