package com.weather.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "forecast_table")
public class Forecast {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int forcast_id;
	String date;
	int index;

	@OneToMany(cascade = CascadeType.ALL)
	List<DayNight> dayNightRounds;

	public Forecast() {
	}

	public Forecast(String date, int index) {
		super();
		this.date = date;
		this.index = index;
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

	public int getForcast_id() {
		return forcast_id;
	}

	public void setForcast_id(int forcast_id) {
		this.forcast_id = forcast_id;
	}

	public List<DayNight> getDayNightRounds() {
		return dayNightRounds;
	}

	public void setDayNightRounds(List<DayNight> dayNightRounds) {
		this.dayNightRounds = dayNightRounds;
	}

	@Override
	public String toString() {
		return "Forecast [forcast_id=" + forcast_id + ", date=" + date + ", index=" + index + ", dayNightRounds="
				+ dayNightRounds + "]\n";
	}

}
