package com.jg.util;

import java.util.ArrayList;

import com.jg.model.Inventory;
import com.jg.model.Item;
import com.jg.model.Item.ItemCategory;
import com.jg.model.List;
import com.jg.model.Trip;

public class ItemSelector {

	public static void checkWeatherConditions(Item.ItemCategory itemCategory, Trip trip) {
		Inventory inventory = trip.getInventory();
		ArrayList<Item> tripPackingList = trip.getItems();
		switch (itemCategory){
		case ESSENTIAL:
			tripPackingList.addAll(inventory.getEssentialList());
			break;
		case COLD:
			tripPackingList.addAll(inventory.getColdList());
			break;
		case HOT:
			tripPackingList.addAll(inventory.getHotList());
			break;
		case RAINY:
			tripPackingList.addAll(inventory.getRainyList());
			break;
		case SUNNY:
			tripPackingList.addAll(inventory.getSunnyList());
			break;
		case WINDY:
			tripPackingList.addAll(inventory.getWindyList());
			break;
		}
	}
	
	public static void addWeatherBasedItems(Trip trip) {
		ArrayList<Item.ItemCategory> addedWeatherItemConditions = new ArrayList<Item.ItemCategory>(); 
		for (int j = trip.getStartDate(); j <= trip.getEndDate(); j++) {
			if (j > 15) {
				break;
			}
			List list = trip.getAPIData().getList()[j];
			int weatherCode = list.getWeather()[0].getId();
			double minTemp = list.getTemp().getMin();
			double maxTemp = list.getTemp().getMax();
			if (weatherIsRainy(weatherCode) && !addedWeatherItemConditions.contains(ItemCategory.RAINY)) {
				addItemsToTrip(trip, addedWeatherItemConditions, Item.ItemCategory.RAINY);
			} else if (weatherIsSunny(weatherCode) && !addedWeatherItemConditions.contains(ItemCategory.SUNNY)) {
				addItemsToTrip(trip, addedWeatherItemConditions, Item.ItemCategory.SUNNY);
			} else if (weatherIsCold(minTemp) && !addedWeatherItemConditions.contains(ItemCategory.COLD)) {
				addItemsToTrip(trip, addedWeatherItemConditions, Item.ItemCategory.COLD);
			} else if (weatherIsHot(maxTemp) && !addedWeatherItemConditions.contains(ItemCategory.HOT)) {
				addItemsToTrip(trip, addedWeatherItemConditions, Item.ItemCategory.HOT);
			} else if (weatherIsWindy(weatherCode)&& !addedWeatherItemConditions.contains(ItemCategory.WINDY)) {
				addItemsToTrip(trip, addedWeatherItemConditions, Item.ItemCategory.WINDY);
			}
		}
	}

	private static void addItemsToTrip(Trip trip, ArrayList<Item.ItemCategory> addedWeatherItemConditions, ItemCategory weather) {
		checkWeatherConditions(weather, trip);
		addedWeatherItemConditions.add(weather);
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
		ArrayList<Item> items = trip.getItems();
		for (int j = trip.getStartDate(); j < trip.getEndDate(); j++) {
			for (int i = 9; i <= 12; i++) {
				newQuantity = items.get(i).getQuantity();
				items.get(i).setQuantity(++newQuantity);
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
