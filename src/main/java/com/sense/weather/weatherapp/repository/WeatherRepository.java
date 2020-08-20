package com.sense.weather.weatherapp.repository;

import com.sense.weather.weatherapp.domain.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, String> {
}
