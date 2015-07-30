package travelItems;

public class Item {

	String name;
	int maxTemp;
	int minTemp;
	int itemWeatherCode;
	public boolean include;

	public Item(String name, int minTemp, int maxTemp, int itemWeatherCode, boolean include) {
		super();
		this.name = name;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.itemWeatherCode = itemWeatherCode;
		this.include = include;
	}


	public void includes(int apiWeatherCode) {
		//this will account for items needed when raining
		if (apiWeatherCode < 600 && apiWeatherCode > 0 && itemWeatherCode < 600 && itemWeatherCode > 0 ){
			include = true;
		}
		//this will account for items needed for sunny days
		else if (itemWeatherCode >=800 && itemWeatherCode < 900 && apiWeatherCode/100 == itemWeatherCode/100 && apiWeatherCode % 10 <= itemWeatherCode % 10){
			include = true;
		}
		//this will account for items needed for snow days
		else if (apiWeatherCode >= 600 && apiWeatherCode < 700 && apiWeatherCode / 100 == itemWeatherCode / 100){
			include = true;
		}
	}
	
	public void includes(int apiWeatherCode, double apiMinTemp, double apiMaxTemp) {
		//this will account for items needed when raining
		if (apiWeatherCode < 600 && apiWeatherCode > 0 && itemWeatherCode < 600 && itemWeatherCode > 0 ){
			include = true;
		}
		//this will account for items needed for sunny days
		else if (itemWeatherCode >=800 && itemWeatherCode < 900 && apiWeatherCode/100 == itemWeatherCode/100 && apiWeatherCode % 10 <= itemWeatherCode % 10){
			include = true;
		}
		//this will account for items needed for snow days
		else if (apiWeatherCode >= 600 && apiWeatherCode < 700 && apiWeatherCode / 100 == itemWeatherCode / 100){
			include = true;
		}
		//this will account for items needed for cold days
		else if ( maxTemp > 0 && apiMaxTemp <= maxTemp){
			include = true;}
		
		//this will account for items need for hot days
		else if ( minTemp > 0 && apiMinTemp >= minTemp){
			include = true;}
		
		//this will account for items needed for extreme hot days
		//else if (WeatherMap.getExtreme() == 904){
			//include = true;}
		
		//this will account for items needed for extreme cold days
		//else if (WeatherMap.getExtreme() == 903){
			//include = true;}
	}

	
}


