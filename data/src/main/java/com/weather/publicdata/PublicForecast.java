package com.weather.publicdata;

public class PublicForecast {

	int forcast_id;
	String date;

	PublicDay pday;
	PublicNight pnight;

	public PublicForecast(int forcast_id, String date, PublicDay pday, PublicNight pnight) {
		super();
		this.forcast_id = forcast_id;
		this.date = date;
		this.pday = pday;
		this.pnight = pnight;
	}

	public PublicForecast(String date, PublicDay pday, PublicNight pnight) {
		super();
		this.date = date;
		this.pday = pday;
		this.pnight = pnight;
	}

	public int getForcast_id() {
		return forcast_id;
	}

	public void setForcast_id(int forcast_id) {
		this.forcast_id = forcast_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public PublicDay getPday() {
		return pday;
	}

	public void setPday(PublicDay pday) {
		this.pday = pday;
	}

	public PublicNight getPnight() {
		return pnight;
	}

	public void setPnight(PublicNight pnight) {
		this.pnight = pnight;
	}

	@Override
	public String toString() {
		return "PublicForecast [forcast_id=" + forcast_id + ", date=" + date + ", pday=" + pday + ", pnight=" + pnight
				+ "]\n";
	}

}
