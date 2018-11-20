package com.weather.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class will not be saved into database since we only need it for jaxb
 * parsing in the incoming xml doc..
 * 
 * @author burhanc
 *
 */
/**
 * @author burhanc
 *
 */
@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Forecasts {

	@XmlElement(name = "forecast")
	List<Forecast> forecasts;

	public Forecasts() {
	}

	public Forecasts(List<Forecast> forecasts) {
		this.forecasts = forecasts;
	}

	@Override
	public String toString() {
		return "Forecasts{forecasts=" + forecasts + '}';
	}

	public List<Forecast> getForecasts() {
		return forecasts;
	}

	public void setForecasts(List<Forecast> forecasts) {
		this.forecasts = forecasts;
	}

}
