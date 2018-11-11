package com.weather.publicdata;

public class PublicCity {

	int place_id;
	public String name;
	public String phenomenon;
	public int tempmin;

	public PublicCity() {
	}

	
	public PublicCity(int place_id, String name, String phenomenon, int tempmin) {
		super();
		this.place_id = place_id;
		this.name = name;
		this.phenomenon = phenomenon;
		this.tempmin = tempmin;
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

}
