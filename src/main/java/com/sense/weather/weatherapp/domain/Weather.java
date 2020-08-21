package com.sense.weather.weatherapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@RedisHash(value = "weather", timeToLive = 1800)
public class Weather implements Serializable {
    private static final long serialVersionUID = 6856422938636751255L;

    private String id;

    private String cityName;

    private Double temp;

    private String description;

    public Weather(String id, String cityName, Double temp, String description) {
        this.id = id;
        this.cityName = cityName;
        this.temp = temp;
        this.description = description;
    }
}
