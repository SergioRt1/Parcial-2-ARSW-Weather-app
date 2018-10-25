package com.example.Weathers.services;

import com.example.Weathers.beans.WeathersPersitence;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeathersServicesStub implements WeathersServices {

    @Autowired
    WeathersPersitence persitence;

    public WeathersServicesStub() {
    }

    @Override
    public String getWeather(String city) throws WeathersServicesException {
        return persitence.getWeather(city);
    }


}
