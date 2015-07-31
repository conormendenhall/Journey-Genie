package travelItemsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import jSONConverterProject.WeatherObjectConverter;
import travelItems.Item;
import travelItems.PackingList;
import travelItems.Trip;
import travelItems.WeatherMap;

public class ProjPracTest {

	@Test
	public void shouldReturnTrueforEssentialItemIsTrue() {
		PackingList p = new PackingList();
		p.getToothpaste().includes(301, 0, 300);
		assertEquals(true, p.getToothpaste().include);
	}

	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForRainCodes() {
		PackingList p = new PackingList();
		p.getRainJacket().includes(222, 0, 300);
		assertEquals(true, p.getRainJacket().include);

	}

	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForSunAndNoCloudsIsTrue() {
		PackingList p = new PackingList();
		p.getSunGlasses().includes(802, 0, 300);
		assertEquals(true, p.getSunGlasses().include);
	}

	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForColdTemperatureIsTrue() {
		PackingList p = new PackingList();
		p.getScarf().includes(802, 20, 40);
		assertEquals(true, p.getScarf().include);
	}

	@Test
	public void testIfNewTripHasConditioner() {
		Trip t = new Trip();
		assertEquals("conditioner", t.getItems().get(0).getName());
	}

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
//		t.setApiWeatherCode(WeatherObjectConverter.convert(s).list[0].weather[0].id);
//		t.setApiMinTemp(0);
//		t.setApiMaxTemp(300);
		assertEquals("snow boots", t.getItems().get(10).getName());
	}
	
	@Test
	public void itemArrayListIndex10ShouldBeSummerDressNotSnowBootsForHotDay() throws Exception {
		String s = "{\"cod\":\"200\",\"message\":0.0032,\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\"country\":\"JP\"},\"cnt\":10,\"list\":[{\"dt\":1406080800,\"temp\":{\"day\":297.77,\"min\":80,\"max\":100,\"night\":293.52,\"eve\":297.77,\"morn\":297.77},\"pressure\":925.04,\"humidity\":76,\"weather\":[{\"id\":602,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]}]}";
		PackingList p = new PackingList();
		p.fillStagingList();
		Trip t = new Trip();
		t.setWeatherInfoObject(WeatherObjectConverter.convert(s));
//		t.setApiWeatherCode(WeatherObjectConverter.convert(s).list[0].weather[0].id);
//		t.setApiMinTemp(80);
//		t.setApiMaxTemp(100);
		System.out.println("Min temp: " + t.getApiMinTemp());
		System.out.println("Max temp: " + t.getApiMaxTemp());
		assertEquals("summer dress", t.getItems().get(10).getName());
	}
	//
	// @Test
	// public void
	// shouldReturnTrueForNonEssentialItemNeededForHotTemperatureIsTrue () {
	// Item sunGlasses = new Item("sun Glasses", 80, 0, 0, false);
	// WeatherMap.setTemp(85);
	// sunGlasses.includes();
	// assertEquals(true, sunGlasses.include);
	// }
	//
	// @Test
	// public void shouldReturnTrueForNonEssentialItemNeededForSnowCodes () {
	// Item snowBoots = new Item("snow boots", 0, 0, 601, false);
	// WeatherMap.setWeatherCode(602);
	// snowBoots.includes();
	// assertEquals(true, snowBoots.include);
	//
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
	//
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
