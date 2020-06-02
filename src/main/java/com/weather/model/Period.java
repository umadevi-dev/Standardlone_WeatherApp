package com.weather.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Period {
    public Period() {
    }

    @JsonProperty("number")
    private  int number;

    @JsonProperty("name")
    private String name;

    @JsonProperty("startTime")
    private String startTime;

    @JsonProperty("endTime")
    private String endTime;

    @JsonProperty("isDaytime")
    private boolean isDaytime;

    @JsonProperty("temperature")
    private int temperature;

    @JsonProperty("temperatureUnit")
    private String temperatureUnit;

    @JsonProperty("temperatureTrend")
    private String  temperatureTrend;

    @JsonProperty("windSpeed")
    private String  windSpeed;

    @JsonProperty("windDirection")
    private String windDirection;

    @JsonProperty("icon")
    private String  icon;

    @JsonProperty("shortForecast")
    private String shortForecast;

    @JsonProperty("detailedForecast")
    private String detailedForecast;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isDaytime() {
        return isDaytime;
    }

    public void setDaytime(boolean daytime) {
        isDaytime = daytime;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public String getTemperatureTrend() {
        return temperatureTrend;
    }

    public void setTemperatureTrend(String temperatureTrend) {
        this.temperatureTrend = temperatureTrend;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getShortForecast() {
        return shortForecast;
    }

    public void setShortForecast(String shortForecast) {
        this.shortForecast = shortForecast;
    }

    public String getDetailedForecast() {
        return detailedForecast;
    }

    public void setDetailedForecast(String detailedForecast) {
        this.detailedForecast = detailedForecast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return number == period.number &&
                isDaytime == period.isDaytime &&
                temperature == period.temperature &&
                Objects.equals(name, period.name) &&
                Objects.equals(startTime, period.startTime) &&
                Objects.equals(endTime, period.endTime) &&
                Objects.equals(temperatureUnit, period.temperatureUnit) &&
                Objects.equals(temperatureTrend, period.temperatureTrend) &&
                Objects.equals(windSpeed, period.windSpeed) &&
                Objects.equals(windDirection, period.windDirection) &&
                Objects.equals(icon, period.icon) &&
                Objects.equals(shortForecast, period.shortForecast) &&
                Objects.equals(detailedForecast, period.detailedForecast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, startTime, endTime, isDaytime, temperature, temperatureUnit, temperatureTrend, windSpeed, windDirection, icon, shortForecast, detailedForecast);
    }

    @Override
    public String toString() {
        return "Period{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", isDaytime=" + isDaytime +
                ", temperature=" + temperature +
                ", temperatureUnit='" + temperatureUnit + '\'' +
                ", temperatureTrend='" + temperatureTrend + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", icon='" + icon + '\'' +
                ", shortForecast='" + shortForecast + '\'' +
                ", detailedForecast='" + detailedForecast + '\'' +
                '}';
    }


}
