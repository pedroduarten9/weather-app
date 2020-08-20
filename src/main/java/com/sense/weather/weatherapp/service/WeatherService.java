package com.sense.weather.weatherapp.service;

import com.sense.weather.weatherapp.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final OpenWeatherClient openWeatherClient;

    @Autowired
    public WeatherService(OpenWeatherClient openWeatherClient) {
        this.openWeatherClient = openWeatherClient;
    }

    public String getWeatherByCityId(int cityId) {
        WeatherResponse weatherResponse = openWeatherClient.getWeatherByCityId(cityId);

        return String.format("Temperature now in %s is %s Celsius and if you look to the sky you see %s.",
                weatherResponse.getName(), weatherResponse.getMain().getTemp(),
                weatherResponse.getWeather().get(0).getDescription());
    }
}