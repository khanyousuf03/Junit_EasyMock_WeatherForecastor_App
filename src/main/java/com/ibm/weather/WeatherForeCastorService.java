package com.ibm.weather;

public class WeatherForeCastorService {

	private IWeatherForeCastor iforeCastor;

	/**
	 * This method is used to get
	 * temperature details from webservice
	 * This logic acting as consumer 
	 * @param zipcode
	 * @return
	 */
	public double findTemperature(long zipcode) {
		double temperature = 0.0;

		if (zipcode > 0) {
			// hit web service using zipcode to get response
			//web service call
			temperature = iforeCastor.getTemperature(zipcode);
			// format response in required obj
		}

		return temperature;
	}

	public void setIforeCastor(IWeatherForeCastor iforeCastor) {
		this.iforeCastor = iforeCastor;
	}

}
