package com.weather.utility.controller;

import java.util.ArrayList;
import java.util.List;

import com.weather.data.Day;
import com.weather.data.Forecast;
import com.weather.data.Night;
import com.weather.data.Place;
import com.weather.publicdata.PublicDay;
import com.weather.publicdata.PublicForecast;
import com.weather.publicdata.PublicNight;
import com.weather.publicdata.PublicPlace;

/**
 * Class converts database related objects to public objects which is safe in
 * case of setting and changing the entity fields it maybe automatically
 * commited to the db so this is not a something i want to do
 * 
 * @author burhanc
 *
 */
public class PublicConverter {

	private boolean greatConverter = false;
	private String cityName = null;

	/**
	 * Forecast entity to Public converter with filter parameters
	 * 
	 * @param fc
	 * @param cityName
	 * @return
	 */
	public PublicForecast filterAndConvertFrom(Forecast fc, String cityName) {
		this.cityName = cityName;
		this.greatConverter = true;
		return convertFrom(fc);
	}

	/**
	 * Forecast entity to Public converter.
	 * 
	 * @param fc
	 * @return
	 */
	public PublicForecast convertFrom(Forecast fc) {

		if (fc == null) {
			return null;
		}

		PublicForecast pforecast = new PublicForecast(fc.getDate(), convertDay(fc.getDay()),
				convertNight(fc.getNight()));
		clear();
		return pforecast;

	}

	/**
	 * from entity Night to Public Night
	 * 
	 * @param night
	 * @return
	 */
	private PublicNight convertNight(Night night) {

		if (night == null) {
			return null;
		}

		return new PublicNight(night.getPhenomenon(), night.getTempmin(), night.getTempmax(), night.getText(),
				night.getSea(), night.getPeipsi(), convertPlaces(night.getPlaces()));
	}

	/**
	 * From entity Day to Public Day
	 * 
	 * @param day
	 * @return
	 */
	private PublicDay convertDay(Day day) {
		if (day == null) {
			return null;
		}

		return new PublicDay(day.getPhenomenon(), day.getTempmin(), day.getTempmax(), day.getText(), day.getSea(),
				day.getPeipsi(), convertPlaces(day.getPlaces()));
	}

	/**
	 * From entity Place to Public Place & filter if greatConverter is true and city
	 * name is provided
	 * 
	 * @param places
	 * @return
	 */
	private List<PublicPlace> convertPlaces(List<Place> places) {
		if (places == null || places.size() == 0) {
			return null;
		}
		List<PublicPlace> pplaces = new ArrayList<>();

		places.stream().forEach(place -> {
			if (this.greatConverter == false && this.cityName == null) {
				pplaces.add(new PublicPlace(place.getName(), place.getPhenomenon(), place.getTempmin()));
			} else {
				if (this.cityName.equalsIgnoreCase(place.getName())) {
					// returns only the city we requested.
					pplaces.add(new PublicPlace(place.getName(), place.getPhenomenon(), place.getTempmin()));
				}
			}
		});

		return pplaces;
	}

	private void clear() {
		this.greatConverter = false;
		this.cityName = null;
	}

}
