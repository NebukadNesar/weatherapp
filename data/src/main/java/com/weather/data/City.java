package com.weather.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <place> <name>Türi</name> <phenomenon>Fog</phenomenon> <tempmin>3</tempmin>
 * </place>
 */
@Entity
@Table(name = "places_table")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int place_id;
	public String name;
	public String phenomenon;
	public int tempmin;

	@ManyToOne
	@JoinColumn(name = "daynight_id")
	DayNight dayNight;

	public City() {
	}

	public City(String name, String phenomenon, int tempmin) {
		super();
		this.name = name;
		this.phenomenon = phenomenon;
		this.tempmin = tempmin;
	}

	public DayNight getDayNight() {
		return dayNight;
	}

	public void setDayNight(DayNight dayNight) {
		this.dayNight = dayNight;
	}

	public int getPlace_id() {
		return place_id;
	}

	public void setPlace_id(int place_id) {
		this.place_id = place_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "City [place_id=" + place_id + ", name=" + name + ", phenomenon=" + phenomenon + ", tempmin=" + tempmin
				+ "]\n";
	}

}
