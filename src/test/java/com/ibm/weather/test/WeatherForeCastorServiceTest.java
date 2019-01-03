package com.ibm.weather.test;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ibm.weather.IWeatherForeCastor;
import com.ibm.weather.WeatherForeCastorService;

public class WeatherForeCastorServiceTest {

	private static IWeatherForeCastor iforeCastor;
	private static WeatherForeCastorService service;

	@BeforeClass
	public static void before() {
		// creating WeatherForeCastorService obj
		service = new WeatherForeCastorService();

		// Creating mock object for interface
		iforeCastor = EasyMock.createMock(IWeatherForeCastor.class);

		// Setting dummy behaviour for WeatherForeCastor
		EasyMock.expect(iforeCastor.getTemperature(500081)).andReturn(42.14);
		EasyMock.expect(iforeCastor.getTemperature(500082)).andReturn(41.14);
		EasyMock.expect(iforeCastor.getTemperature(500031)).andReturn(35.14);
		EasyMock.replay(iforeCastor);

		// inject mock obj into service
		service.setIforeCastor(iforeCastor);
	}

	@Test
	public void testGetTemperature() {
		double temp = service.findTemperature(500081);
		System.out.println("Temperature : " + temp);
	}

	@AfterClass
	public static void after() {

	}

}
