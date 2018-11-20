package com.weather.publicdata;

public class PublicWind {

	String name;
	String direction;
	int speedmin;
	int speedmax;
	String gust;

	public PublicWind() {
	}

	public PublicWind(String name, String direction, int speedmin, int speedmax, String gust) {
		super();
		this.name = name;
		this.direction = direction;
		this.speedmin = speedmin;
		this.speedmax = speedmax;
		this.gust = gust;
	}

	@Override
	public String toString() {
		return "PublicWind [name=" + name + ", direction=" + direction + ", speedmin=" + speedmin + ", speedmax="
				+ speedmax + ", gust=" + gust + "]";
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

}
