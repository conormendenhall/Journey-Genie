package com.jg.util;

import com.jg.model.Item;
import com.jg.model.Trip;

public class ItemSelector {

	public static void checkWeatherConditions(Item item, int apiWeatherCode, double apiMinTemp, double apiMaxTemp) {
		// switch statement?
		// hash map?

		// this will account for items needed for rainy days
		if ((apiWeatherCode >= 200 && apiWeatherCode < 600) && (item.getItemCategory().contains("rainy"))) {
			item.setIncluded(true);
		}
		// this will account for items needed for sunny days
		else if ((apiWeatherCode >= 800 && apiWeatherCode <= 802)
				&& (item.getItemCategory().equalsIgnoreCase("sunny"))) {
			item.setIncluded(true);
		}
		// this will account for items needed for snow days
		else if ((apiWeatherCode >= 600 && apiWeatherCode < 700) && (item.getItemCategory().equalsIgnoreCase("snow"))) {
			item.setIncluded(true);
		}
		// this will account for items needed for cold days
		else if ((apiMinTemp <= 40) && (item.getItemCategory().equalsIgnoreCase("cold"))) {
			item.setIncluded(true);
		}

		// this will account for items needed for hot days
		else if ((apiMaxTemp >= 75) && (item.getItemCategory().equalsIgnoreCase("hot"))) {
			item.setIncluded(true);
		}

		// this will account for items needed for windy days
		else if ((apiWeatherCode == 905 || (apiWeatherCode >= 953 && apiWeatherCode <= 957))
				&& (item.getItemCategory().equalsIgnoreCase("windy"))) {
			item.setIncluded(true);
		}
	}

	public static void countEssentialQuantitySpecificItems(Trip trip) {
		int newQuantity = 0;
		for (int j = trip.getStartDate(); j < trip.getEndDate(); j++) {
			for (int i = 9; i <= 12; i++) {
				newQuantity = trip.getItems().get(i).getQuantity();
				trip.getItems().get(i).setQuantity(++newQuantity);
			}
		}
	}

	public static void addNonEssentialItemsToInventory(Trip trip) {

		for (int j = trip.getStartDate(); j <= trip.getEndDate(); j++) {
			if (j > 15) {
				break;
			}
			for (int i = 0; i < trip.getInventory().getStagingList().size(); i++) {
				ItemSelector.checkWeatherConditions(trip.getInventory().getStagingList().get(i),
						trip.getAPIData().getList()[j].getWeather()[0].getId(),
						trip.getAPIData().getList()[j].getTemp().getMin(),
						trip.getAPIData().getList()[j].getTemp().getMax());
				if (trip.getInventory().getStagingList().get(i).isIncluded() == true) {
					if (!trip.getItems().contains(trip.getInventory().getStagingList().get(i))) {
						trip.getItems().add(trip.getInventory().getStagingList().get(i));
					} else if (trip.getInventory().getStagingList().get(i).getName().equals("shorts")) {
						trip.getItems().get(trip.getItems().indexOf(trip.getInventory().getStagingList().get(i)))
								.setQuantity(
										trip.getItems()
												.get(trip.getItems()
														.indexOf(trip.getInventory().getStagingList().get(i)))
										.getQuantity() + 1);
					}
					if (trip.getInventory().getStagingList().get(i).getName().equals("shorts")) {
						trip.getItems().get(12).setQuantity(trip.getItems().get(12).getQuantity() - 1);
					}
				}
			}
		}
	}
}
