package com.weather.utility;

public interface CommonData {
	
	public static final String request_url = "http://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng";

	public static final String request_period = "0 */30 * ? * *";

	public static final String charsetStandart = "iso-8859-1";

	public static final String applicationReturnType = "application/xml";

	public static final String userAgentProperty = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.155 Safari/537.36";

	public static final String GET = "GET";

	public static final String POST = "POST";
	
}