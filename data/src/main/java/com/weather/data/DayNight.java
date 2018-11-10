package com.weather.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "daynight_table")
public class DayNight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int daynight_id;
	String phenomenon;
	int tempmin;
	int tempmax;
	String description;
	String sea;
	String pepsi;
	int daynight; // 1 - day, 0 - night

	@OneToMany(cascade = CascadeType.ALL)
	List<City> cities;

	@ManyToOne
	@JoinColumn(name = "forcast_id")
	Forecast forecast;

	public DayNight() {
	}

	public DayNight(String phenomenon, int tempmin, int tempmax, String description, int daynight) {
		super();
		this.phenomenon = phenomenon;
		this.tempmin = tempmin;
		this.tempmax = tempmax;
		this.description = description;
		this.daynight = daynight;
	}

	public DayNight(String phenomenon, int tempmin, int tempmax, String description, String sea, String pepsi,
			int daynight) {
		super();
		this.phenomenon = phenomenon;
		this.tempmin = tempmin;
		this.tempmax = tempmax;
		this.description = description;
		this.sea = sea;
		this.pepsi = pepsi;
		this.daynight = daynight;
	}

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

	public int getDayNight_id() {
		return daynight_id;
	}

	public void setDayNight_id(int daynight_id) {
		this.daynight_id = daynight_id;
	}

	public int getDaynight_id() {
		return daynight_id;
	}

	public void setDaynight_id(int daynight_id) {
		this.daynight_id = daynight_id;
	}

	public String getSea() {
		return sea;
	}

	public void setSea(String sea) {
		this.sea = sea;
	}

	public String getPepsi() {
		return pepsi;
	}

	public void setPepsi(String pepsi) {
		this.pepsi = pepsi;
	}

	public int getTempmin() {
		return tempmin;
	}

	public void setTempmin(int tempmin) {
		this.tempmin = tempmin;
	}

	public int getDaynight() {
		return daynight;
	}

	public void setDaynight(int daynight) {
		this.daynight = daynight;
	}

	public String getPhenomenon() {
		return phenomenon;
	}

	public void setPhenomenon(String phenomenon) {
		this.phenomenon = phenomenon;
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

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "DayNight [daynight_id=" + daynight_id + ", phenomenon=" + phenomenon + ", tempmin=" + tempmin
				+ ", tempmax=" + tempmax + ", description=" + description + ", daynight=" + daynight + ", forcast="
				+ ", cities=" + cities.toString() + "]\n";
	}

}
