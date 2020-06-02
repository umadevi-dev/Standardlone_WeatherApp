package com.weather.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

    @JsonProperty("periods")
    private List<Period> periodList = new ArrayList<>();

    public List<Period> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<Period> periodList) {
        this.periodList = periodList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forecast forecast = (Forecast) o;
        return Objects.equals(periodList, forecast.periodList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(periodList);
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "periodList=" + periodList +
                '}';
    }
}
