package com.sense.weather.weatherapp.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    GENERIC_BAD_REQUEST(HttpStatus.BAD_REQUEST, 1, "invalid request"),

    CITY_NOT_FOUND(HttpStatus.NOT_FOUND, 1, "City not found"),

    OPEN_WEATHER_API_EXCEPTION(HttpStatus.SERVICE_UNAVAILABLE, 1, "Open weather api not available"),
    ;

    private HttpStatus httpStatus;
    private int internalCode;
    private String description;
}
