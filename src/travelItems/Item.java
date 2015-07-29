package travelItems;

public class Item {

	String name;
	int maxTemp;
	int minTemp;
	int Cloud;
	int weatherCode;
	int extreme;
	boolean essentialItem;
	public boolean include;
	String warning;

	public Item(String name, int minTemp, int maxTemp, int cloud, int weatherCode, int extreme, boolean essentialItem, boolean include, String warning) {
		super();
		this.name = name;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.weatherCode = weatherCode;
		this.extreme = extreme;
		this.essentialItem = essentialItem;
		this.include = include;
		this.warning = warning;
	}


	public void includes() {
		
		if (essentialItem == true){
			include = true;
			}
		//this will account for items needed when raining
		else if (WeatherMap.getWeatherCode() < 600 && WeatherMap.getWeatherCode() > 0 && weatherCode < 600 && weatherCode > 0 ){
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
		else if (WeatherMap.getExtreme() == 904 && extreme == WeatherMap.getExtreme()){
			warning = "Heat Advisory! Please pack accordingly";
			include = true;}
		
		//this will account for items needed for extreme cold days
		else if (WeatherMap.getExtreme() == 903 && extreme == WeatherMap.getExtreme()){
			warning = "Cold Advisory! Please pack accordingly";
			include = true;}
		
		//this will account for items needed for windy days
		
		else {include = false;}
	}

	
}

