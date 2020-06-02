package com.weather.model.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpUtil {
	private static final Logger logger = LogManager.getLogger(HttpUtil.class);

	public static String getApiResponse(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		logger.debug(" Connecting url is " + urlString);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/ld+json");
		conn.setRequestProperty("Content-Type", "application/ld+json");
		try (InputStream inputStream = new BufferedInputStream(conn.getInputStream());) {
			return org.apache.commons.io.IOUtils.toString(inputStream, "UTF-8");
		}

	}
}