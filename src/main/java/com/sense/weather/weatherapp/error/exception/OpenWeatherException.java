package com.sense.weather.weatherapp.error.exception;


import com.sense.weather.weatherapp.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OpenWeatherException extends BaseException {

    private HttpStatus status;

    public OpenWeatherException(ErrorCode errorCode) {
        super(errorCode);
    }

    public OpenWeatherException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
