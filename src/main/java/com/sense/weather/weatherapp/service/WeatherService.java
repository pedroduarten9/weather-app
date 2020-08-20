package com.sense.weather.weatherapp.service;

import com.sense.weather.weatherapp.domain.Weather;
import com.sense.weather.weatherapp.repository.WeatherRepository;
import com.sense.weather.weatherapp.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final OpenWeatherClient openWeatherClient;
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(OpenWeatherClient openWeatherClient, WeatherRepository weatherRepository) {
        this.openWeatherClient = openWeatherClient;
        this.weatherRepository = weatherRepository;
    }

    public String getWeatherByCityId(int cityId) {
        String cityIdString = String.valueOf(cityId);
        Weather weather = weatherRepository.findById(cityIdString)
                .orElseGet(() -> getWeatherFromApi(cityId, cityIdString));

        return String.format("Temperature now in %s is %s Celsius and if you look to the sky you see %s.",
                weather.getCityName(), weather.getTemp(), weather.getDescription());
    }

    private Weather getWeatherFromApi(int cityId, String cityIdString) {
        WeatherResponse weatherResponse = openWeatherClient.getWeatherByCityId(cityId);

        Weather weather = new Weather(cityIdString, weatherResponse.getName(),
                weatherResponse.getMain().getTemp(), weatherResponse.getWeather().get(0).getDescription());
        weatherRepository.save(weather);

        return weather;
    }
}