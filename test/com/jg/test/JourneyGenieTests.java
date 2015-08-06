package com.jg.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jg.obj.WeatherObjectConverter;
import com.jg.trip.Inventory;
import com.jg.trip.ItemController;
import com.jg.trip.Trip;
import com.jg.trip.TripController;

public class JourneyGenieTests {

	@Test(expected = Exception.class)
	public void weatherObjectConverterShouldThrowExceptionWhenPassedEmptyString() throws Exception {
		WeatherObjectConverter.convert("");
	}

	@Test
	public void weatherInfoObjectShouldHaveAllParametersFromJSONString() {
		String defaultJSon = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":293.52,\"max\":297.77,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		assertEquals(200, WeatherObjectConverter.convert(defaultJSon).cod);
		assertEquals(1851632, WeatherObjectConverter.convert(defaultJSon).city.id);
		assertEquals("Shuzenji", WeatherObjectConverter.convert(defaultJSon).city.name);
		assertEquals(138.933334, WeatherObjectConverter.convert(defaultJSon).city.coord.lon, 0.0000001);
		assertEquals(34.966671, WeatherObjectConverter.convert(defaultJSon).city.coord.lat, 0.0000001);
		assertEquals("JP", WeatherObjectConverter.convert(defaultJSon).city.country);
		assertEquals(10, WeatherObjectConverter.convert(defaultJSon).cnt);
		assertEquals(1406080800, WeatherObjectConverter.convert(defaultJSon).list[0].dt);
		assertEquals(297.77, WeatherObjectConverter.convert(defaultJSon).list[0].temp.day, 0.0001);
		assertEquals(293.52, WeatherObjectConverter.convert(defaultJSon).list[0].temp.min, 0.0001);
		assertEquals(297.77, WeatherObjectConverter.convert(defaultJSon).list[0].temp.max, 0.0001);
		assertEquals(293.52, WeatherObjectConverter.convert(defaultJSon).list[0].temp.night, 0.0001);
		assertEquals(297.77, WeatherObjectConverter.convert(defaultJSon).list[0].temp.eve, 0.0001);
		assertEquals(297.77, WeatherObjectConverter.convert(defaultJSon).list[0].temp.morn, 0.0001);
		assertEquals(803, WeatherObjectConverter.convert(defaultJSon).list[0].weather[0].id);
		assertEquals(925.04, WeatherObjectConverter.convert(defaultJSon).list[0].pressure, 0.0001);
		assertEquals(76, WeatherObjectConverter.convert(defaultJSon).list[0].humidity);
	}

	@Test
	public void includedShouldReturnTrueforEssentialItem() {
		Inventory inventory = new Inventory();
		ItemController.checkWeatherConditions(inventory.getToothpaste(), 0, 0, 0);
		assertEquals(true, inventory.getToothpaste().isIncluded());
	}

	@Test
	public void includedShouldReturnTrueForColdItemOnColdDay() {
		Inventory inventory = new Inventory();
		ItemController.checkWeatherConditions(inventory.getScarf(), 0, 10, 40);
		assertEquals(true, inventory.getScarf().isIncluded());
	}

	@Test
	public void includedShouldReturnTrueForHotItemOnHotDay() {
		Inventory inventory = new Inventory();
		ItemController.checkWeatherConditions(inventory.getShorts(), 0, 80, 90);
		assertEquals(true, inventory.getShorts().isIncluded());
	}

	@Test
	public void shouldReturnTrueForSunnyItemNeededOnSunnyDay() {
		Inventory inventory = new Inventory();
		ItemController.checkWeatherConditions(inventory.getSunGlasses(), 800, 0, 0);
		ItemController.checkWeatherConditions(inventory.getSunBlock(), 801, 0, 0);
		ItemController.checkWeatherConditions(inventory.getSunHat(), 802, 0, 0);
		assertEquals(true, inventory.getSunGlasses().isIncluded());
		assertEquals(true, inventory.getSunBlock().isIncluded());
		assertEquals(true, inventory.getSunHat().isIncluded());
	}

	@Test
	public void includedShouldReturnTrueForRainyItemOnRainyDay() {
		Inventory inventory = new Inventory();
		ItemController.checkWeatherConditions(inventory.getRainJacket(), 300, 0, 0);
		ItemController.checkWeatherConditions(inventory.getUmbrella(), 300, 0, 0);
		assertEquals(true, inventory.getRainJacket().isIncluded());
		assertEquals(true, inventory.getUmbrella().isIncluded());
	}

	// @Test
	// public void essentialItemsShouldBeInPackingList() {
	// PackingList p = new PackingList();
	// Trip t = new Trip();
	// assertContains( , );
	// }

	@Test
	public void testIfStagingListHasSnowBoots() {
		Inventory inventory = new Inventory();
		inventory.fillStagingList();
		assertEquals("snow boots", inventory.getStagingList().get(0).getName());
	}

	@Test
	public void itemsArrayListShouldBePopulatedWithItemsFromStagingList() throws Exception {
		String s = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":0,\"max\":30,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":602,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Inventory inventory = new Inventory();
		inventory.fillStagingList();
		Trip trip = new Trip();
		trip.setWeatherInfoObject(WeatherObjectConverter.convert(s));
		assertEquals("underwear", trip.getItems().get(10).getName());
	}

	@Test
	public void itemArrayListIndex12ShouldBeSummerDressNotSnowBootsForHotDay() throws Exception {
		String defaultJSon = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":80,\"max\":100,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":602,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Inventory inventory = new Inventory();
		inventory.fillStagingList();
		Trip trip = new Trip();
		trip.setWeatherInfoObject(WeatherObjectConverter.convert(defaultJSon));
		assertEquals("pants", trip.getItems().get(12).getName());
	}

	@Test
	public void quantityOfUnderwearShouldBe2For2DayTrip() {
		String defaultJSon = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":80,\"max\":100,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":602,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip trip = new Trip();
		trip.setWeatherInfoObject(WeatherObjectConverter.convert(defaultJSon));
		trip.setStartDate(4);
		trip.setEndDate(5);
		TripController.countEssentialQuantitySpecificItems(trip);
		assertEquals(2, trip.getItems().get(10).getQuantity());
	}

}
