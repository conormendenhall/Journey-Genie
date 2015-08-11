package com.jg.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.jg.model.APIData;
import com.jg.model.City;
import com.jg.model.Coord;
import com.jg.model.Inventory;
import com.jg.model.Item;
import com.jg.model.List;
import com.jg.model.Temp;
import com.jg.model.Trip;
import com.jg.model.Weather;
import com.jg.util.ItemSelector;
import com.jg.util.TripObjectAssembler;
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

	@Test
	public void includedShouldReturnTrueforEssentialItem() throws IOException {
		boolean expected = false;
		String defaultJSON = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":293.52,\"max\":297.77,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip trip = TripObjectAssembler.generatePackingList(defaultJSON, "0", "0");
		ArrayList<Item> packingList = trip.getItems();
		for (Item item : packingList) {
			if(item.getName().equals("underwear"))
			{
				expected = true;
			}
		}
		assertEquals(true, expected);
	}

	@Test
	public void includedShouldReturnTrueForColdItemOnColdDay() throws IOException {
		boolean expected = false;
		String defaultJSON = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":0,\"max\":30,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip trip = TripObjectAssembler.generatePackingList(defaultJSON, "0", "0");
		ArrayList<Item> packingList = trip.getItems();
		for (Item item : packingList) {
			if(item.getName().equals("snow boots"))
			{
				expected = true;
			}
		}
		assertEquals(true, expected);
	}

	@Test
	public void includedShouldReturnTrueForHotItemOnHotDay() throws IOException {
		boolean expected = false;
		String defaultJSON = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":90,\"max\":110,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip trip = TripObjectAssembler.generatePackingList(defaultJSON, "0", "0");
		ArrayList<Item> packingList = trip.getItems();
		for (Item item : packingList) {
		if(item.getName().equals("shorts"))
		{
			expected = true;
		}
	}
	assertEquals(true, expected);
}


	@Test
	public void shouldReturnTrueForSunnyItemNeededOnSunnyDay() throws IOException {
		boolean expected = false;
		String defaultJSON = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":90,\"max\":110,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":800,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip trip = TripObjectAssembler.generatePackingList(defaultJSON, "0", "0");
		ArrayList<Item> packingList = trip.getItems();
		for (Item item : packingList) {
		if(item.getName().equals("sunblock"))
		{
			expected = true;
		}
	}
	assertEquals(true, expected);
	}

	@Test
	public void includedShouldReturnTrueForRainyItemOnRainyDay() throws IOException {
		boolean expected = false;
		String defaultJSON = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":90,\"max\":110,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":300,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip trip = TripObjectAssembler.generatePackingList(defaultJSON, "0", "0");
		ArrayList<Item> packingList = trip.getItems();
		for (Item item : packingList) {
		if(item.getName().equals("rain jacket"))
		{
			expected = true;
		}
	}
	assertEquals(true, expected);
	}

	@Test
	public void essentialItemsShouldBeInEssentialList() throws IOException {
		boolean expected = false;
		String defaultJSON = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":90,\"max\":110,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":300,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip t = TripObjectAssembler.generatePackingList(defaultJSON, "0", "0");
		Inventory i = t.getInventory();
		ArrayList<Item> essentials = i.getEssentialList();
		for (Item item : essentials) {
			if(item.getName().equals("conditioner"))
			{
				expected = true;
			}
		}
		assertEquals(true, expected);
	}

	@Test
	public void testIfColdListHasSnowBoots() throws IOException {
		boolean expected = false;
		String defaultJSON = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":0,\"max\":30,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip t = TripObjectAssembler.generatePackingList(defaultJSON, "0", "0");
		Inventory i = t.getInventory();
		ArrayList<Item> essentials = i.getColdList();
		for (Item item : essentials) {
			if(item.getName().equals("snow boots"))
			{
				expected = true;
			}
		}
		assertEquals(true, expected);
	}

	@Test
	public void testIfSunnyListHasSunblock() throws Exception {
		boolean expected = false;
		String defaultJSON = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":0,\"max\":30,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip t = TripObjectAssembler.generatePackingList(defaultJSON, "0", "0");
		Inventory i = t.getInventory();
		ArrayList<Item> essentials = i.getSunnyList();
		for (Item item : essentials) {
			if(item.getName().equals("sunblock"))
			{
				expected = true;
			}
		}
		assertEquals(true, expected);
	}
	
	@Test
	public void testIfRainyListHasRainCoat() throws Exception {
		boolean expected = false;
		String defaultJSON = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":0,\"max\":30,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip t = TripObjectAssembler.generatePackingList(defaultJSON, "0", "0");
		Inventory i = t.getInventory();
		ArrayList<Item> essentials = i.getRainyList();
		for (Item item : essentials) {
			if(item.getName().equals("rain jacket"))
			{
				expected = true;
			}
		}
		assertEquals(true, expected);
	}
	
	@Test
	public void testIfWindyListHasWindBreaker() throws Exception {
		boolean expected = false;
		String defaultJSON = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":0,\"max\":30,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip t = TripObjectAssembler.generatePackingList(defaultJSON, "0", "0");
		Inventory i = t.getInventory();
		ArrayList<Item> essentials = i.getWindyList();
		for (Item item : essentials) {
			if(item.getName().equals("wind breaker"))
			{
				expected = true;
			}
		}
		assertEquals(true, expected);
	}

	
	
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
