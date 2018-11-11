package com.weather.publicdata;

import java.util.List;

import com.weather.data.DayNight;

public class PublicForecast {
	int forcast_id;
	String date;
	int index;

	List<PublicDayNight> dayNightRounds;

	public PublicForecast() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PublicForecast(int forcast_id, String date, int index, List<PublicDayNight> dayNightRounds) {
		super();
		this.forcast_id = forcast_id;
		this.date = date;
		this.index = index;
		this.dayNightRounds = dayNightRounds;
	}

	public int getForcast_id() {
		return forcast_id;
	}

	public void setForcast_id(int forcast_id) {
		this.forcast_id = forcast_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public List<PublicDayNight> getDayNightRounds() {
		return dayNightRounds;
	}

	public void setDayNightRounds(List<PublicDayNight> dayNightRounds) {
		this.dayNightRounds = dayNightRounds;
	}

}
