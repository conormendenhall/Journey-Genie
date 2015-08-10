package com.jg.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jg.model.APIData;
import com.jg.model.City;
import com.jg.model.Coord;
import com.jg.model.Inventory;
import com.jg.model.List;
import com.jg.model.Temp;
import com.jg.model.Trip;
import com.jg.model.Weather;
import com.jg.util.ItemSelector;
import com.jg.util.WeatherObjectAssembler;

public class JourneyGenieTests {

	@Test(expected = Exception.class)
	public void weatherObjectConverterShouldThrowExceptionWhenPassedEmptyString() throws Exception {
		WeatherObjectAssembler.convert("");
	}

	@Test
	public void weatherInfoObjectShouldHaveAllParametersFromJSONString() {
		String defaultJSON = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":293.52,\"max\":297.77,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		APIData data = WeatherObjectAssembler.convert(defaultJSON);
		City city = data.getCity();
		Coord coord = city.getCoord();
		List[] list = data.getList();
		Temp temp = list[0].getTemp();
		Weather[] weather = list[0].getWeather();

		assertEquals(200, data.getCod());
		assertEquals(1851632, city.getId());
		assertEquals("Shuzenji", city.getName());
		assertEquals(138.933334, coord.getLon(), 0.0000001);
		assertEquals(34.966671, coord.getLat(), 0.0000001);
		assertEquals("JP", city.getCountry());
		assertEquals(10, data.getCnt());
		assertEquals(1406080800, list[0].getDt());
		assertEquals(297.77, temp.getDay(), 0.0001);
		assertEquals(293.52, temp.getMin(), 0.0001);
		assertEquals(297.77, temp.getMax(), 0.0001);
		assertEquals(293.52, temp.getNight(), 0.0001);
		assertEquals(297.77, temp.getEve(), 0.0001);
		assertEquals(297.77, temp.getMorn(), 0.0001);
		assertEquals(803, weather[0].getId());
		assertEquals(925.04, list[0].getPressure(), 0.0001);
		assertEquals(76, list[0].getHumidity());
	}

//	@Test
//	public void includedShouldReturnTrueforEssentialItem() {
//		Inventory inventory = new Inventory();
//		Trip trip = new Trip();
//
//		ItemSelector.checkWeatherConditions(inventory.getToothpaste(), trip, 0, 0, 0);
//		boolean expected = inventory.getToothpaste().isIncluded();
//
//		assertEquals(true, expected);
//	}
//
//	@Test
//	public void includedShouldReturnTrueForColdItemOnColdDay() {
//		Inventory inventory = new Inventory();
//		Trip trip = new Trip();
//
//		ItemSelector.checkWeatherConditions(inventory.getScarf(), trip, 0, 10, 40);
//		boolean expected = inventory.getScarf().isIncluded();
//		assertEquals(true, expected);
//	}
//
//	@Test
//	public void includedShouldReturnTrueForHotItemOnHotDay() {
//		Inventory inventory = new Inventory();
//		Trip trip = new Trip();
//
//		ItemSelector.checkWeatherConditions(inventory.getShorts(), trip, 0, 80, 90);
//		assertEquals(true, inventory.getShorts().isIncluded());
//	}
//
//	@Test
//	public void shouldReturnTrueForSunnyItemNeededOnSunnyDay() {
//		Inventory inventory = new Inventory();
//		Trip trip = new Trip();
//
//		ItemSelector.checkWeatherConditions(inventory.getSunGlasses(), trip, 800, 0, 0);
//		ItemSelector.checkWeatherConditions(inventory.getSunBlock(), trip, 801, 0, 0);
//		ItemSelector.checkWeatherConditions(inventory.getSunHat(), trip, 802, 0, 0);
//
//		boolean expected = inventory.getSunGlasses().isIncluded();
//		assertEquals(true, expected);
//
//		boolean expected2 = inventory.getSunBlock().isIncluded();
//		assertEquals(true, expected2);
//
//		boolean expected3 = inventory.getSunHat().isIncluded();
//		assertEquals(true, expected3);
//	}
//
//	@Test
//	public void includedShouldReturnTrueForRainyItemOnRainyDay() {
//		Inventory inventory = new Inventory();
//		Trip trip = new Trip();
//
//		ItemSelector.checkWeatherConditions(inventory.getRainJacket(), trip, 300, 0, 0);
//		ItemSelector.checkWeatherConditions(inventory.getUmbrella(), trip, 300, 0, 0);
//		assertEquals(true, inventory.getRainJacket().isIncluded());
//		assertEquals(true, inventory.getUmbrella().isIncluded());
//	}

//	@Test
//	public void essentialItemsShouldBeInPackingList() {
//		Inventory i = new Inventory();
//		Trip t = new Trip();
//		String actual = null;
//		String expected = null;
//		assertEquals(actual, expected);
//	}

//	@Test
//	public void testIfStagingListHasSnowBoots() {
//		Inventory inventory = new Inventory();
//		inventory.fillCategoryLists();
//		assertEquals("snow boots", inventory.getStagingList().get(0).getName());
//	}
//
//	@Test
//	public void itemsArrayListShouldBePopulatedWithItemsFromStagingList() throws Exception {
//		String s = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":0,\"max\":30,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":602,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
//		Inventory inventory = new Inventory();
//		inventory.fillCategoryLists();
//		Trip trip = new Trip();
//		trip.setAPIData(WeatherObjectConverter.convert(s));
//		assertEquals("underwear", trip.getItems().get(10).getName());
//	}

	@Test
	public void itemArrayListIndex12ShouldBeSummerDressNotSnowBootsForHotDay() throws Exception {
		String defaultJSon = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":80,\"max\":100,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":602,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Inventory inventory = new Inventory();
		inventory.fillCategoryLists();
		Trip trip = new Trip();
		trip.setAPIData(WeatherObjectAssembler.convert(defaultJSon));
		assertEquals("pants", trip.getItems().get(12).getName());
	}

	@Test
	public void quantityOfUnderwearShouldBe2For2DayTrip() {
		String defaultJSon = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":80,\"max\":100,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":602,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip trip = new Trip();
		trip.setAPIData(WeatherObjectAssembler.convert(defaultJSon));
		trip.setStartDate(4);
		trip.setEndDate(5);
		ItemSelector.countEssentialQuantitySpecificItems(trip);
		assertEquals(2, trip.getItems().get(10).getQuantity());
	}

}
