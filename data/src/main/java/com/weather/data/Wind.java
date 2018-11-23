package com.weather.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "wind")
@XmlRootElement(name = "wind")
@XmlAccessorType(XmlAccessType.FIELD)
public class Wind implements Serializable {

	private static final long serialVersionUID = 8794614254218859916L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int wind_id;

	@XmlElement
	String name;

	@XmlElement
	String direction;

	@XmlElement
	int speedmin;

	@XmlElement
	int speedmax;

	@XmlElement
	String gust;

	@ManyToOne
	@JoinColumn(name = "night_id")
	Night night;

	@ManyToOne
	@JoinColumn(name = "day_id")
	Day day;

	public Wind() {
	}

	public Wind(int wind_id, String name, String direction, int speedmin, int speedmax, String gust, Night night,
			Day day) {
		super();
		this.wind_id = wind_id;
		this.name = name;
		this.direction = direction;
		this.speedmin = speedmin;
		this.speedmax = speedmax;
		this.gust = gust;
		this.night = night;
		this.day = day;
	}

	public int getWind_id() {
		return wind_id;
	}

	public void setWind_id(int wind_id) {
		this.wind_id = wind_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getSpeedmin() {
		return speedmin;
	}

	public void setSpeedmin(int speedmin) {
		this.speedmin = speedmin;
	}

	public int getSpeedmax() {
		return speedmax;
	}

	public void setSpeedmax(int speedmax) {
		this.speedmax = speedmax;
	}

	public String getGust() {
		return gust;
	}

	public void setGust(String gust) {
		this.gust = gust;
	}

	public Night getNight() {
		return night;
	}

	public void setNight(Night night) {
		this.night = night;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Wind [wind_id=" + wind_id + ", name=" + name + ", direction=" + direction + ", speedmin=" + speedmin
				+ ", speedmax=" + speedmax + ", gust=" + gust +"]";
	}

}
