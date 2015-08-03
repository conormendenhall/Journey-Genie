package travelItemsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import jSONConverterProject.WeatherObjectConverter;
import travelItems.PackingList;
import travelItems.Trip;

public class JourneyGenieTests {

	@Test(expected = Exception.class)
	public void weatherObjectConverterShouldThrowExceptionWhenPassedEmptyString() throws Exception {
		WeatherObjectConverter.convert("");
	}

	@Test
	public void weatherInfoObjectShouldHaveAllParametersFromJSONString() {
		String s = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":293.52,\"max\":297.77,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		assertEquals(200, WeatherObjectConverter.convert(s).cod);
		assertEquals(1851632, WeatherObjectConverter.convert(s).city.id);
		assertEquals("Shuzenji", WeatherObjectConverter.convert(s).city.name);
		assertEquals(138.933334, WeatherObjectConverter.convert(s).city.coord.lon, 0.0000001);
		assertEquals(34.966671, WeatherObjectConverter.convert(s).city.coord.lat, 0.0000001);
		assertEquals("JP", WeatherObjectConverter.convert(s).city.country);
		assertEquals(10, WeatherObjectConverter.convert(s).cnt);
		assertEquals(1406080800, WeatherObjectConverter.convert(s).list[0].dt);
		assertEquals(297.77, WeatherObjectConverter.convert(s).list[0].temp.day, 0.0001);
		assertEquals(293.52, WeatherObjectConverter.convert(s).list[0].temp.min, 0.0001);
		assertEquals(297.77, WeatherObjectConverter.convert(s).list[0].temp.max, 0.0001);
		assertEquals(293.52, WeatherObjectConverter.convert(s).list[0].temp.night, 0.0001);
		assertEquals(297.77, WeatherObjectConverter.convert(s).list[0].temp.eve, 0.0001);
		assertEquals(297.77, WeatherObjectConverter.convert(s).list[0].temp.morn, 0.0001);
		assertEquals(803, WeatherObjectConverter.convert(s).list[0].weather[0].id);
		assertEquals(925.04, WeatherObjectConverter.convert(s).list[0].pressure, 0.0001);
		assertEquals(76, WeatherObjectConverter.convert(s).list[0].humidity);
	}

	@Test
	public void includedShouldReturnTrueforEssentialItem() {
		PackingList p = new PackingList();
		p.getToothpaste().checkWeatherConditions(0, 0, 0);
		assertEquals(true, p.getToothpaste().isIncluded());
	}
	
	@Test
	public void includedShouldReturnTrueForColdItemOnColdDay() {
		PackingList p = new PackingList();
		p.getScarf().checkWeatherConditions(0, 10, 40);
		assertEquals(true, p.getScarf().isIncluded());
	}
	
	@Test
	public void includedShouldReturnTrueForHotItemOnHotDay() {
		PackingList p = new PackingList();
		p.getSleevelessShirt().checkWeatherConditions(0, 80, 90);
		assertEquals(true, p.getSleevelessShirt().isIncluded());
	}

	@Test
	public void shouldReturnTrueForSunnyItemNeededOnSunnyDay() {
		PackingList p = new PackingList();
		p.getSunGlasses().checkWeatherConditions(800, 0, 0);
		p.getSunBlock().checkWeatherConditions(801, 0, 0);
		p.getSunHat().checkWeatherConditions(802, 0, 0);
		assertEquals(true, p.getSunGlasses().isIncluded());
		assertEquals(true, p.getSunBlock().isIncluded());
		assertEquals(true, p.getSunHat().isIncluded());
	}
	
	@Test
	public void includedShouldReturnTrueForRainyItemOnRainyDay() {
		PackingList p = new PackingList();
		p.getRainJacket().checkWeatherConditions(300, 0, 0);
		p.getUmbrella().checkWeatherConditions(300, 0, 0);
		assertEquals(true, p.getRainJacket().isIncluded());
		assertEquals(true, p.getUmbrella().isIncluded());
	}
	
	// @Test
	// public void essentialItemsShouldBeInPackingList() {
	// PackingList p = new PackingList();
	// Trip t = new Trip();
	// assertContains( , );
	// }

	@Test
	public void testIfStagingListHasSnowBoots() {
		PackingList p = new PackingList();
		p.fillStagingList();
		assertEquals("snow boots", p.getStagingList().get(0).getName());
	}

	@Test
	public void itemsArrayListShouldBePopulatedWithItemsFromStagingList() throws Exception {
		String s = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":0,\"max\":30,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":602,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		PackingList p = new PackingList();
		p.fillStagingList();
		Trip t = new Trip();
		t.setWeatherInfoObject(WeatherObjectConverter.convert(s));
		assertEquals("snow boots", t.getItems().get(12).getName());
	}

	@Test
	public void itemArrayListIndex12ShouldBeSummerDressNotSnowBootsForHotDay() throws Exception {
		String s = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":80,\"max\":100,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":602,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		PackingList p = new PackingList();
		p.fillStagingList();
		Trip t = new Trip();
		t.setWeatherInfoObject(WeatherObjectConverter.convert(s));
		assertEquals("summer dress", t.getItems().get(12).getName());
	}

	@Test
	public void quantityOfUnderwearShouldBe2For2DayTrip() {
		String s = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":80,\"max\":100,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":602,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		Trip thisTrip = new Trip();
		thisTrip.setWeatherInfoObject(WeatherObjectConverter.convert(s));
		thisTrip.setStartDate(4);
		thisTrip.setEndDate(5);		
		thisTrip.countEssentialQuantitySpecificItems();
		assertEquals(2, thisTrip.getItems().get(10).getQuantity());
	}
	// @Test
	// public void shouldReturnTrueForNonEssentialItemNeededForSnowCodes () {
	// Item snowBoots = new Item("snow boots", 0, 0, 601, false);
	// WeatherMap.setWeatherCode(602);
	// snowBoots.includes();
	// assertEquals(true, snowBoots.include);
	// }
	//
	// @Test
	// public void
	// shouldReturnTrueForNonEssentialItemNeededForExtremeHotTemperatureIsTrue
	// () {
	// Item sunGlasses = new Item("sunGlasses", 0, 0, 904, false);
	// WeatherMap.setExtreme(904);
	// sunGlasses.includes();
	// assertEquals(true, sunGlasses.include);
	// }
	//
	// @Test
	// public void
	// shouldReturnTrueForNonEssentialItemNeededForExtremeColdTemperatureIsTrue
	// () {
	// Item longUndies = new Item("longUndies", 0, 0, 903, false);
	// WeatherMap.setExtreme(903);
	// longUndies.includes();
	// assertEquals(true, longUndies.include);
	// }
	//
	// /*@Test
	// public void shouldReturnTrueForLongUnderwearWhenTempIs32Degrees() {
	// Item longUnderwear = new Item(-99, 55, false, false, false);
	// WeatherInfo.setTemp(66);
	// assertEquals(true, Item.include(longUnderwear));
	// }
	//
	// @Test
	// public void shouldReturnTrueForWaterWhenTempIs100Degrees() {
	// Item water = new Item(75, 120, false, true, false);
	// WeatherInfo.setSunny(false);
	// assertEquals(true, Item.include(water));
	// }

}
