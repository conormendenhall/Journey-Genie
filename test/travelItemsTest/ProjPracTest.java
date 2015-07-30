package travelItemsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import travelItems.Item;
import travelItems.PackingList;
import travelItems.WeatherMap;


public class ProjPracTest {

	@Test
	public void shouldReturnTrueforEssentialItemIsTrue() {
		PackingList p = new PackingList();
		p.getToothpaste().includes(301);
		assertEquals(true, p.getToothpaste().include);
	}
	
	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForRainCodes () {
		PackingList p = new PackingList();
		p.getRainJacket().includes(222);
		assertEquals(true, p.getRainJacket().include);		

	}	

	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForSunAndNoCloudsIsTrue() {
		PackingList p = new PackingList();
		p.getSunGlasses().includes(802);		
		assertEquals(true, p.getSunGlasses().include);
	}
	
	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForColdTemperatureIsTrue () {
		PackingList p = new PackingList();
		p.getScarf().includes(802, 20, 40);
		assertEquals(true, p.getScarf().include);
	}	
//	
//	@Test
//	public void shouldReturnTrueForNonEssentialItemNeededForHotTemperatureIsTrue () {
//		Item sunGlasses = new Item("sun Glasses", 80, 0, 0, false);
//		WeatherMap.setTemp(85);
//		sunGlasses.includes();
//		assertEquals(true, sunGlasses.include);
//	}
//	
//	@Test
//	public void shouldReturnTrueForNonEssentialItemNeededForSnowCodes () {
//		Item snowBoots = new Item("snow boots", 0, 0, 601, false);
//		WeatherMap.setWeatherCode(602);
//		snowBoots.includes();
//		assertEquals(true, snowBoots.include);
//
//	}	
//	
//	@Test
//	public void shouldReturnTrueForNonEssentialItemNeededForExtremeHotTemperatureIsTrue () {
//		Item sunGlasses = new Item("sunGlasses", 0, 0, 904, false);
//		WeatherMap.setExtreme(904);
//		sunGlasses.includes();
//		assertEquals(true, sunGlasses.include);
//	}
//	
//	@Test
//	public void shouldReturnTrueForNonEssentialItemNeededForExtremeColdTemperatureIsTrue () {
//		Item longUndies = new Item("longUndies", 0, 0, 903, false);
//		WeatherMap.setExtreme(903);
//		longUndies.includes();
//		assertEquals(true, longUndies.include);
//	}
//	
//	
//	
//	/*@Test
//	public void shouldReturnTrueForLongUnderwearWhenTempIs32Degrees() {
//		Item longUnderwear = new Item(-99, 55, false, false, false);
//		WeatherInfo.setTemp(66);
//		assertEquals(true, Item.include(longUnderwear));
//	}
//	
//	@Test
//	public void shouldReturnTrueForWaterWhenTempIs100Degrees() {
//		Item water = new Item(75, 120, false, true, false);
//		WeatherInfo.setSunny(false);
//		assertEquals(true, Item.include(water));
//	}
	
}
