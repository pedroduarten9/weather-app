package com.sense.weather.weatherapp.error;

import lombok.Getter;

@Getter
public class ResponseError {

    private int internalCode;
    private String errorDescription;

    public ResponseError(ErrorCode errorCode) {
        internalCode = errorCode.getInternalCode();
        errorDescription = errorCode.getDescription();
    }

    public ResponseError(String message) {
        this.errorDescription = message;
    }
}
