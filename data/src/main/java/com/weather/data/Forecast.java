package com.weather.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "forecast_table")
@XmlRootElement(name = "forecast")
public class Forecast implements Serializable {

	/**
	 * 
	 */
	@Transient private static final long serialVersionUID = 7118114416475520062L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int forcast_id;
	
	@XmlAttribute(name = "date")
	String date;
	
	int index; //private static field and we can increase it at any time of forecast object creation called..

	@OneToMany(cascade = CascadeType.ALL)
	List<DayNight> dayNightRounds;

	public Forecast() {
		super();
	}

	public Forecast(String date, int index) {
		super();
		this.date = date;
		this.index = index;
	}

	public Forecast(int forcast_id, String date, int index, List<DayNight> dayNightRounds) {
		super();
		this.forcast_id = forcast_id;
		this.date = date;
		this.index = index;
		this.dayNightRounds = dayNightRounds;
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
