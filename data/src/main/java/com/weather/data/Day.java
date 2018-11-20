package com.weather.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "day")
@XmlRootElement(name = "day")
@XmlAccessorType(XmlAccessType.FIELD)
public class Day extends DayNightRounds implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4753357517794751415L;

	/**
	 * <phenomenon>Cloudy with clear spells</phenomenon> <tempmin>-1</tempmin>
	 * <tempmax>3</tempmax> <text> Cloudy with bright spells. Mostly dry. Northeast
	 * wind 5-11, on islands and coastal areas in gusts 14-17 m/s. Air temperature
	 * -1..+3°C. </text>
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int day_id;

	@XmlElement
	String phenomenon;

	@XmlElement
	int tempmin;

	@XmlElement
	int tempmax;

	@Lob
	@XmlElement
	String text;

	@Lob
	@XmlElement
	String sea;

	@Lob
	@XmlElement
	String peipsi;

	@XmlElement(name="wind")
	@OneToMany(cascade = CascadeType.ALL)
	List<Wind> winds;

	@XmlElement(name="place")
	@OneToMany(cascade = CascadeType.ALL)
	List<Place> places;

	@OneToOne
	@JoinColumn(name = "forecast_id")
	Forecast forecast;

	public Day() {
	}

	public Day(String phenomenon, int tempmin, int tempmax, String text, String sea, String peipsi, List<Wind> winds,
			List<Place> places) {
		this.phenomenon = phenomenon;
		this.tempmin = tempmin;
		this.tempmax = tempmax;
		this.text = text;
		this.sea = sea;
		this.peipsi = peipsi;
		this.winds = winds;
		this.places = places;
	}

	@Override
	public String toString() {
		return "Day{" + "phenomenon='" + phenomenon + '\'' + ", tempmin=" + tempmin + ", tempmax=" + tempmax
				+ ", text='" + text + '\'' + ", sea='" + sea + '\'' + ", peipsi='" + peipsi + '\'' + ", winds=" + winds
				+ ", places=" + places + '}';
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public List<Wind> getWinds() {
		return winds;
	}

	public void setWinds(List<Wind> winds) {
		this.winds = winds;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public int getDay_id() {
		return day_id;
	}

	public void setDay_id(int day_id) {
		this.day_id = day_id;
	}

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

	@Override
	public DN getTagName() {
		return DN.DAY;
	}
}
