package com.weather.publicdata;

import java.util.List;

import javax.persistence.Lob;

public class PublicDay {

	int daynight_id;
	String phenomenon;
	int tempmin;
	int tempmax;

	@Lob
	String description;

	@Lob
	String sea;
	@Lob
	String peipsi;
	int daynight; // 1 - day, 0 - night

	List<PublicPlace> places;

	public PublicDay() {
	}

	public PublicDay(int daynight_id, String phenomenon, int tempmin, int tempmax, String description, String sea,
			String peipsi, int daynight, List<PublicPlace> places) {
		super();
		this.daynight_id = daynight_id;
		this.phenomenon = phenomenon;
		this.tempmin = tempmin;
		this.tempmax = tempmax;
		this.description = description;
		this.sea = sea;
		this.peipsi = peipsi;
		this.daynight = daynight;
		this.places = places;
	}

	public PublicDay(String phenomenon, int tempmin, int tempmax, String description, String sea, String peipsi,
			List<PublicPlace> places) {
		super();
		this.phenomenon = phenomenon;
		this.tempmin = tempmin;
		this.tempmax = tempmax;
		this.description = description;
		this.sea = sea;
		this.peipsi = peipsi;
		this.places = places;
	}

	public int getDaynight_id() {
		return daynight_id;
	}

	public void setDaynight_id(int daynight_id) {
		this.daynight_id = daynight_id;
	}

	public String getPhenomenon() {
		return phenomenon;
	}

	public void setPhenomenon(String phenomenon) {
		this.phenomenon = phenomenon;
	}

	public int getTempmin() {
		return tempmin;
	}

	public void setTempmin(int tempmin) {
		this.tempmin = tempmin;
	}

	public int getTempmax() {
		return tempmax;
	}

	public void setTempmax(int tempmax) {
		this.tempmax = tempmax;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSea() {
		return sea;
	}

	public void setSea(String sea) {
		this.sea = sea;
	}

	public String getPeipsi() {
		return peipsi;
	}

	public void setPeipsi(String peipsi) {
		this.peipsi = peipsi;
	}

	public int getDaynight() {
		return daynight;
	}

	public void setDaynight(int daynight) {
		this.daynight = daynight;
	}

	public List<PublicPlace> getPlaces() {
		return places;
	}

	public void setPlaces(List<PublicPlace> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "PublicDay [daynight_id=" + daynight_id + ", phenomenon=" + phenomenon + ", tempmin=" + tempmin
				+ ", tempmax=" + tempmax + ", description=" + description + ", sea=" + sea + ", peipsi=" + peipsi
				+ ", daynight=" + daynight + ", places=" + places + "]";
	}

}
