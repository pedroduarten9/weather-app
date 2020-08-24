package com.sense.weather.weatherapp.service;

import com.sense.weather.weatherapp.error.ErrorCode;
import com.sense.weather.weatherapp.error.exception.OpenWeatherException;
import com.sense.weather.weatherapp.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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

    public WeatherResponse getWeatherByCityId(int cityId) {
        try {
            ResponseEntity<WeatherResponse> weatherResponse = restTemplate.getForEntity(
                    baseUrl.replace(CITY_ID, String.valueOf(cityId)).replace(UNITS, units).replace(APP_ID, appId),
                    WeatherResponse.class);

            if (HttpStatus.NOT_FOUND == weatherResponse.getStatusCode()) {
                throw new OpenWeatherException(ErrorCode.CITY_NOT_FOUND);
            } else if (weatherResponse.getStatusCode().is5xxServerError()) {
                throw new OpenWeatherException(ErrorCode.OPEN_WEATHER_API_EXCEPTION);
            } else {
                return weatherResponse.getBody();
            }
        } catch (HttpClientErrorException e) {
            throw new OpenWeatherException(e.getStatusCode(), e.getMessage());
        } catch (Exception ex) {
            if (ex instanceof OpenWeatherException) {
                throw ex;
            }
            throw new OpenWeatherException(ErrorCode.OPEN_WEATHER_API_EXCEPTION);
        }
    }
}