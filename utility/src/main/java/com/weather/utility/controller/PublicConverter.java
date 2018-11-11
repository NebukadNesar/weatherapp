package com.weather.utility.controller;

import java.util.ArrayList;

import com.weather.data.City;
import com.weather.data.DayNight;
import com.weather.data.Forecast;
import com.weather.publicdata.PublicCity;
import com.weather.publicdata.PublicDayNight;
import com.weather.publicdata.PublicForecast;

/**
 * Class converts database related objects to public objects which is safe in
 * case of setting and changing the entity fields it maybe automatically
 * commited to the db so this is not a something i want to do
 * 
 * @author burhanc
 *
 */
public class PublicConverter {

	public PublicCity cityTo(City city) {
		if (city == null)
			return null;
		return new PublicCity(city.getPlace_id(), city.getName(), city.getPhenomenon(), city.tempmin);
	}

	public PublicDayNight dayNightTo(DayNight dn) {

		if (dn == null)
			return null;
		
		ArrayList<PublicCity> publicCities = null;
		if (dn.getCities() != null) {
			publicCities = new ArrayList<PublicCity>();
			for (int i = 0; i < dn.getCities().size(); i++) {
				publicCities.add(cityTo(dn.getCities().get(i)));
			}
		}

		return new PublicDayNight(dn.getDaynight(), dn.getPhenomenon(), dn.getTempmin(), dn.getTempmax(),
				dn.getDescription(), dn.getSea(), dn.getPeipsi(), dn.getDaynight(), publicCities);

	}

	public PublicForecast forecastTo(Forecast fc) {
		if (fc == null)
			return null;

		ArrayList<PublicDayNight> publicDaynights = null;
		if (fc.getDayNightRounds() != null) {
			publicDaynights = new ArrayList<PublicDayNight>();
			for (int i = 0; i < fc.getDayNightRounds().size(); i++) {
				publicDaynights.add(dayNightTo(fc.getDayNightRounds().get(i)));
			}
		}

		return new PublicForecast(fc.getForcast_id(), fc.getDate(), fc.getIndex(), publicDaynights);

	}

}
