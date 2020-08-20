package com.sense.weather.weatherapp.controller;

import com.sense.weather.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = WeatherController.BASE_URL)
@RestController
public class WeatherController {
    protected static final String BASE_URL = "/weather";

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/city/{cityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getWeatherByCityId(@PathVariable("cityId") int cityId) {
        return ResponseEntity.ok(weatherService.getWeatherByCityId(cityId));
    }
}
