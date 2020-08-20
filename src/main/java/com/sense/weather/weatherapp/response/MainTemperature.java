package com.sense.weather.weatherapp.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MainTemperature implements Serializable {
    private static final long serialVersionUID = 6924510618387557075L;

    private Double temp;
}
