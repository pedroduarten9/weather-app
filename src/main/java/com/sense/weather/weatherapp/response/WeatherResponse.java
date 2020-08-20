package com.sense.weather.weatherapp.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WeatherResponse {

    private String name;

    private MainTemperature main;

    private List<Weather> weather;
}