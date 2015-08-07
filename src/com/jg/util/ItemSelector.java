package com.jg.util;

import com.jg.model.Inventory;
import com.jg.model.Item;
import com.jg.model.List;
import com.jg.model.Trip;

public class ItemSelector {

	public static void checkWeatherConditions(Item.ItemCategory itemCategory, Trip trip) {

		switch (itemCategory){
		case ESSENTIAL:
			trip.getItems().addAll(Inventory.getEssentialList());
		case COLD:
			trip.getItems().addAll(Inventory.getColdList());
		case HOT:
			trip.getItems().addAll(Inventory.getHotList());
		case RAINY:
			trip.getItems().addAll(Inventory.getRainyList());
		case SUNNY:
			trip.getItems().addAll(Inventory.getSunnyList());
		case WINDY:
			trip.getItems().addAll(Inventory.getWindyList());
			break;
		}
	}
	
	public static void addWeatherBasedItems(Trip trip) {
		for (int j = trip.getStartDate(); j <= trip.getEndDate(); j++) {
			if (j > 15) {
				break;
			}
			List list = trip.getAPIData().getList()[j];
			int weatherCode = list.getWeather()[0].getId();
			double minTemp = list.getTemp().getMin();
			double maxTemp = list.getTemp().getMax();
			if (weatherIsRainy(weatherCode)) {
				checkWeatherConditions(Item.ItemCategory.RAINY, trip);
			} else if (weatherIsSunny(weatherCode)) {
				checkWeatherConditions(Item.ItemCategory.SUNNY, trip);
			} else if (weatherIsCold(minTemp)) {
				checkWeatherConditions(Item.ItemCategory.COLD, trip);
			} else if (weatherIsHot(maxTemp)) {
				checkWeatherConditions(Item.ItemCategory.HOT, trip);
			} else if (weatherIsWindy(weatherCode)) {
				checkWeatherConditions(Item.ItemCategory.WINDY, trip);
			}
		}
	}

	private static boolean weatherIsHot(double maxTemp) {
		return maxTemp >= 75;
	}

	private static boolean weatherIsWindy(int weatherCode) {
		return weatherCode == 905 || ((weatherCode >= 953) && (weatherCode <= 957));
	}

	private static boolean weatherIsRainy(int weatherCode) {
		return weatherCode >= 200 && weatherCode <600;
	}

	private static boolean weatherIsSunny(int weatherCode) {
		return weatherCode >= 800 && weatherCode <= 802;
	}

	private static boolean weatherIsCold(double apiMinTemp) {
		return apiMinTemp <= 40;
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

//	public static void addNonEssentialItemsToInventory(Trip trip) {
//
//		for (int j = trip.getStartDate(); j <= trip.getEndDate(); j++) {
//			if (j > 15) {
//				break;
//			}
//			for (int i = 0; i < trip.getInventory().getStagingList().size(); i++) {
//				List list = trip.getAPIData().getList()[j];
//				ItemSelector.checkWeatherConditions(trip.getInventory().getStagingList().get(i),
//						trip, list.getWeather()[0].getId(), list.getTemp().getMin(), list.getTemp().getMax());
//				if (trip.getInventory().getStagingList().get(i).isIncluded() == true) {
//					if (!trip.getItems().contains(trip.getInventory().getStagingList().get(i))) {
//						trip.getItems().add(trip.getInventory().getStagingList().get(i));
//					} else if (trip.getInventory().getStagingList().get(i).getName().equals("shorts")) {
//						trip.getItems().get(trip.getItems().indexOf(trip.getInventory().getStagingList().get(i)))
//								.setQuantity(
//										trip.getItems()
//												.get(trip.getItems()
//														.indexOf(trip.getInventory().getStagingList().get(i)))
//										.getQuantity() + 1);
//					}
//					if (trip.getInventory().getStagingList().get(i).getName().equals("shorts")) {
//						trip.getItems().get(12).setQuantity(trip.getItems().get(12).getQuantity() - 1);
//					}
//				}
//			}
//		}
//	}
}
