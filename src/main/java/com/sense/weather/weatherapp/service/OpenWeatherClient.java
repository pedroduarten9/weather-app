package com.sense.weather.weatherapp.service;

import com.sense.weather.weatherapp.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherClient {
    private static final String APP_ID = "{appId}";
    private static final String UNITS = "{units}";
    private static final String CITY_ID = "{cityId}";

    private final RestTemplate restTemplate;

    @Value("${weather.api.url}")
    private String baseUrl;

    @Value("${weather.api.units}")
    private String units;

    @Value("${weather.api.app.id}")
    private String appId;

    @Autowired
    public OpenWeatherClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeatherByCityId(int cityId){
        return restTemplate.getForEntity(
                baseUrl.replace(CITY_ID, String.valueOf(cityId)).replace(UNITS, units).replace(APP_ID, appId),
                WeatherResponse.class)
                .getBody();
    }
}