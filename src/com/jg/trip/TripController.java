package com.jg.trip;

public class TripController {

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
			for (int i = 0; i < trip.getInventory().stagingList.size(); i++) {
				ItemController.checkWeatherConditions(trip.getInventory().stagingList.get(i),
						trip.getWeatherInfoObject().list[j].weather[0].id, trip.getWeatherInfoObject().list[j].temp.min,
						trip.getWeatherInfoObject().list[j].temp.max);
				if (trip.getInventory().stagingList.get(i).isIncluded() == true) {
					if (!trip.getItems().contains(trip.getInventory().stagingList.get(i))) {
						trip.getItems().add(trip.getInventory().stagingList.get(i));
					} else if (trip.getInventory().stagingList.get(i).getName().equals("shorts")) {
						trip.getItems().get(trip.getItems().indexOf(trip.getInventory().stagingList.get(i)))
								.setQuantity(trip.getItems()
										.get(trip.getItems().indexOf(trip.getInventory().stagingList.get(i)))
										.getQuantity() + 1);
					}
					if (trip.getInventory().stagingList.get(i).getName().equals("shorts")) {
						trip.getItems().get(12).setQuantity(trip.getItems().get(12).getQuantity() - 1);
					}

				}

			}
		}
	}
}
