package jSONConverterProject;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;

public class TestJson {

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

}
