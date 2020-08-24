package com.sense.weather.weatherapp.advice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sense.weather.weatherapp.error.ErrorCode;
import com.sense.weather.weatherapp.error.ResponseError;
import com.sense.weather.weatherapp.error.exception.BaseException;
import com.sense.weather.weatherapp.error.exception.OpenWeatherException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ResponseError> handleMethodArgumentNotValidException() {
        return ResponseEntity.status(ErrorCode.GENERIC_BAD_REQUEST.getHttpStatus())
                .body(new ResponseError(ErrorCode.GENERIC_BAD_REQUEST));
    }

    @ExceptionHandler(InvalidFormatException.class)
    ResponseEntity<ResponseError> handleInvalidFormatException() {
        return ResponseEntity.status(ErrorCode.GENERIC_BAD_REQUEST.getHttpStatus())
                .body(new ResponseError(ErrorCode.GENERIC_BAD_REQUEST));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    ResponseEntity<ResponseError> handleMethodArgumentTypeMismatchException() {
        return ResponseEntity.status(ErrorCode.GENERIC_BAD_REQUEST.getHttpStatus())
                .body(new ResponseError(ErrorCode.GENERIC_BAD_REQUEST));
    }

    @ExceptionHandler(BaseException.class)
    ResponseEntity<ResponseError> handleBaseException(BaseException ex) {
        return ResponseEntity.status(ex.getErrorCode().getHttpStatus())
                .body(new ResponseError(ex.getErrorCode()));
    }

    @ExceptionHandler(OpenWeatherException.class)
    ResponseEntity<ResponseError> handleOpenWeatherException(OpenWeatherException ex) {
        if (ex.getErrorCode() != null) {
            return handleBaseException(ex);
        }
        return ResponseEntity.status(ex.getStatus())
                .body(new ResponseError(ex.getMessage()));
    }
}
