package com.weather;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.weather.model.Forecast;
import com.weather.model.Period;
import com.weather.model.PointsResponse;
import com.weather.model.util.HttpUtil;

public class WeatherApp {
	private static final Logger logger = LogManager.getLogger(WeatherApp.class);

	public static void main(String[] args) {

		if (args.length == 2) {
			try {
				PointsResponse pointsApiResponse = getPoints(args[0], args[1]);
				if (pointsApiResponse.getForecast() != null) {
					List<Period> periodsList = getForeCastDetails(pointsApiResponse.getForecast());
					logger.debug(" List size: {}",  periodsList.size());
					periodsList.subList(0, 10).forEach(day -> {
						String response = "name " + day.getName() + " - Number " + day.getNumber()
						+ " DetailedForecast " + day.getDetailedForecast() + " - StartTime "
						+ day.getStartTime() + " EndTime " + day.getEndTime() + " - Icon " + day.getIcon()
						+ " Temperature " + day.getTemperature() + " - Temperature Unit "
						+ day.getTemperatureUnit() + " ShortForeCast " + day.getShortForecast()
						+ " - Detailed Forecast " + day.getDetailedForecast() + " Temperature Trend "
						+ day.getTemperatureTrend() + " - Detailed Forecast " + day.getWindDirection()
						+ " Wind Speed" + day.getWindSpeed() + "\n";
						
						logger.info(response);
						System.out.println(response);
					});
				}
			} catch (IOException e) {
				logger.error("Error occured", e);
			}
		} else {
			logger.error("invalid input");
		}
	}

	private static PointsResponse getPoints(String latitude, String longitude)
			throws ProtocolException, MalformedURLException, IOException {

		try {
			String urlString = "https://api.weather.gov/points/" + latitude + "," + longitude;
			logger.debug(" Constructed url string is " + urlString);
			String response = HttpUtil.getApiResponse(urlString);
			ObjectMapper objectMapper = new ObjectMapper();
			PointsResponse pointsResponse = objectMapper.readValue(response, PointsResponse.class);
			return pointsResponse;
		} catch (Exception e) {
			logger.error("failed to connect" + e.getMessage());
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private static List<Period> getForeCastDetails(String forecastUrl)
			throws ProtocolException, MalformedURLException, IOException {
		try {

			logger.info(" Constructed url string is {}", forecastUrl);
			String response = HttpUtil.getApiResponse(forecastUrl);
			ObjectMapper objectMapper = new ObjectMapper();
			Forecast forecastApiResponse = objectMapper.readValue(response, Forecast.class);
			return forecastApiResponse.getPeriodList();

		} catch (Exception e) {
			logger.error("failed to connect", e);
		}
		return Collections.EMPTY_LIST;
	}

}
