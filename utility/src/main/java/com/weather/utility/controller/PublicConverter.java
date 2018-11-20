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

	public PublicForecast convertFrom(Forecast fc) {

		if (fc == null) {
			return null;
		}

		PublicForecast pforecast = new PublicForecast(fc.getDate(), convertDay(fc.getDay()),
				convertNight(fc.getNight()));

		return pforecast;

	}

	private PublicNight convertNight(Night night) {

		if (night == null) {
			return null;
		}

		return new PublicNight(night.getPhenomenon(), night.getTempmin(), night.getTempmax(), night.getText(),
				night.getSea(), night.getPeipsi(), convertPlaces(night.getPlaces()));
	}

	private List<PublicPlace> convertPlaces(List<Place> places) {
		if (places == null || places.size() == 0) {
			return null;
		}
		List<PublicPlace> pplaces = new ArrayList<>();
		places.stream().forEach(place -> {
			pplaces.add(new PublicPlace(place.getName(), place.getPhenomenon(), place.getTempmin()));
		});

		return pplaces;
	}
	

	private PublicDay convertDay(Day day) {
		if (day == null) {
			return null;
		}

		return new PublicDay(day.getPhenomenon(), day.getTempmin(), day.getTempmax(), day.getText(), day.getSea(),
				day.getPeipsi(), convertPlaces(day.getPlaces()));
	}

}
