package travelItemsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import travelItems.Item;
import travelItems.WeatherMap;


public class ProjPracTest {

	@Test
	public void shouldReturnTrueforEssentialItemIsTrue() {
		Item toothbrush = new Item("tooth brush", 0, 0, 0, 0, 0, true, false, null);
		toothbrush.includes();
		assertEquals(true, toothbrush.include);

	}
	
	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForRainCodes () {
		Item raincoat = new Item("rain coat", 0, 0, 0, 202, 0, false, false, null);
		Item rainShoes = new Item("rain shoes", 0, 0, 0, 513, 0, false, false, null);
		WeatherMap.setWeatherCode(212);
		raincoat.includes();
		rainShoes.includes();
		assertEquals(true, raincoat.include);		
		assertEquals(true, rainShoes.include);

	}	

	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForSunAndNoCloudsIsTrue() {
		Item hat = new Item("hat", 0, 0, 0, 802, 0, false, false, null);
		WeatherMap.setWeatherCode(801);
		hat.includes();		
		assertEquals(true, hat.include);
	}
	
	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForColdTemperatureIsTrue () {
		Item scarf = new Item("scarf", 0, 40, 0, 0, 0, false, false, null);
		WeatherMap.setTemp(25);
		scarf.includes();
		assertEquals(true, scarf.include);
	}	
	
	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForHotTemperatureIsTrue () {
		Item sunGlasses = new Item("sun Glasses", 80, 0, 0, 0, 0, false, false, null);
		WeatherMap.setTemp(85);
		sunGlasses.includes();
		assertEquals(true, sunGlasses.include);
	}
	
	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForSnowCodes () {
		Item snowBoots = new Item("snow boots", 0, 0, 0, 601, 0, false, false, null);
		WeatherMap.setWeatherCode(602);
		snowBoots.includes();
		assertEquals(true, snowBoots.include);

	}	
	
	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForExtremeHotTemperatureIsTrue () {
		Item sunGlasses = new Item("sunGlasses", 0, 0, 0, 0, 904, false, false, null);
		WeatherMap.setExtreme(904);
		sunGlasses.includes();
		assertEquals(true, sunGlasses.include);
	}
	
	@Test
	public void shouldReturnTrueForNonEssentialItemNeededForExtremeColdTemperatureIsTrue () {
		Item longUndies = new Item("longUndies", 0, 0, 0, 0, 903, false, false, null);
		WeatherMap.setExtreme(903);
		longUndies.includes();
		assertEquals(true, longUndies.include);
	}
	
	
	
	/*@Test
	public void shouldReturnTrueForLongUnderwearWhenTempIs32Degrees() {
		Item longUnderwear = new Item(-99, 55, false, false, false);
		WeatherInfo.setTemp(66);
		assertEquals(true, Item.include(longUnderwear));
	}
	
	@Test
	public void shouldReturnTrueForWaterWhenTempIs100Degrees() {
		Item water = new Item(75, 120, false, true, false);
		WeatherInfo.setSunny(false);
		assertEquals(true, Item.include(water));
	}*/
	
}
