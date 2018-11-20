package com.weather.data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "forecast")
@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class Forecast {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int forecast_id;
	
	@XmlAttribute
	String date;

	@XmlElement
	@OneToOne(cascade = CascadeType.ALL)
	Day day;

	@XmlElement
	@OneToOne(cascade = CascadeType.ALL)
	Night night;

	public Forecast() {
	}

	public Forecast(String date, Day day, Night night) {
		this.date = date;
		this.day = day;
		this.night = night;
	}

	@Override
	public String toString() {
		return "Forecast{" + "date='" + date + '\'' + ", day=" + day + ", night=" + night + "}\n";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Night getNight() {
		return night;
	}

	public void setNight(Night night) {
		this.night = night;
	}
}
