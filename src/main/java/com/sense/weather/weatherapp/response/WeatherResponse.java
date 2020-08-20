package com.sense.weather.weatherapp.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = 111847977724430027L;

    private String name;

    private MainTemperature main;

    private List<Weather> weather;
}