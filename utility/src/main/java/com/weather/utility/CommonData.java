package com.weather.utility;

public interface CommonData {

	public static final String REQUEST_URI = "http://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng";

	public static final String REQUEST_PERIOD = "0 */30 * ? * *";

	public static final String CHARSET_STANDART = "iso-8859-1";

	public static final String APPDATA_MIME_TYPE = "application/xml";

	public static final String USER_AGENT_PROPERTY = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.155 Safari/537.36";

	public static final String GET = "GET";

	public static final String POST = "POST";

}