package com.sense.weather.weatherapp.error.exception;

import com.sense.weather.weatherapp.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = -3167394358742434231L;

    private ErrorCode errorCode;

    public BaseException(String message) {
        super(message);
    }
}
