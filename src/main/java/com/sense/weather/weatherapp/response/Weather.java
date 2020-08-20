package com.sense.weather.weatherapp.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Weather implements Serializable {
    private static final long serialVersionUID = 1415154645904794082L;

    private String description;
}
