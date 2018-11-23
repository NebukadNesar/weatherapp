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
@Table(name = "place")
@XmlRootElement(name = "place")
@XmlAccessorType(XmlAccessType.FIELD)
public class Place implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1760102917716090951L;

	/**
	 * <name>Harku</name> <phenomenon>Variable clouds</phenomenon>
	 * <tempmin>4</tempmin>
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int place_id;

	@XmlElement
	String name;

	@XmlElement
	String phenomenon;

	@XmlElement
	int tempmin;

	@ManyToOne
	@JoinColumn(name = "day_id")
	Day day;

	@ManyToOne
	@JoinColumn(name = "night_id")
	Night night;

	public Place() {
	}

	public Place(String name, String phenomenon, int tempmin) {
		this.name = name;
		this.phenomenon = phenomenon;
		this.tempmin = tempmin;
	}

	public Place(String name, String phenomenon, int tempmin, Day day, Night night) {
		super();
		this.name = name;
		this.phenomenon = phenomenon;
		this.tempmin = tempmin;
		this.day = day;
		this.night = night;
	}

	@Override
	public String toString() {
		return "Place [name=" + name + ", phenomenon=" + phenomenon + ", tempmin=" + tempmin + "]";
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
