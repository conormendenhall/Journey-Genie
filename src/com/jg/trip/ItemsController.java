package com.jg.trip;

public class ItemsController {
	
	public static void checkWeatherConditions(Item item, int apiWeatherCode, double apiMinTemp, double apiMaxTemp) {
		// this will account for items needed for rainy days
		if ((apiWeatherCode >= 200 && apiWeatherCode < 600) && (item.getItemCategory().contains("rainy"))) {
			item.setIncluded(true);	
		}
		//this will account for items needed for sunny days
		else if ((apiWeatherCode >= 800 && apiWeatherCode <=802) && (item.getItemCategory().equalsIgnoreCase("sunny"))) {
			item.setIncluded(true);
		}
		// this will account for items needed for snow days
		else if ((apiWeatherCode >= 600 && apiWeatherCode < 700) && (item.getItemCategory().equalsIgnoreCase("snow"))) {
			item.setIncluded(true);
		}
		// this will account for items needed for cold days
		else if ((apiMinTemp <= 40) && (item.getItemCategory().equalsIgnoreCase("cold"))){
			item.setIncluded(true);
		}
		
		// this will account for items needed for hot days
		else if ((apiMaxTemp >= 75) && (item.getItemCategory().equalsIgnoreCase("hot"))){
			item.setIncluded(true);
		}
		
		// this will account for items needed for windy days
		else if ((apiWeatherCode == 905 || (apiWeatherCode >= 953 && apiWeatherCode <= 957)) && (item.getItemCategory().equalsIgnoreCase("windy"))){
			item.setIncluded(true);
		}
		
	}
	
}
