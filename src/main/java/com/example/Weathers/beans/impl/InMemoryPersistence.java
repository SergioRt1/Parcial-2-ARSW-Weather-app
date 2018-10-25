package com.example.Weathers.beans.impl;

import com.example.Weathers.beans.HttpConnection;
import com.example.Weathers.beans.WeathersPersitence;
import com.example.Weathers.services.WeathersServicesException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InMemoryPersistence implements WeathersPersitence {
    
    @Autowired
    HttpConnection externalAPI;
    
    private Map<String, String> cache;
    
    public InMemoryPersistence() {
        cache = new ConcurrentHashMap<>();
    }
    
    @Override
    public String getWeather(String city) throws WeathersServicesException {
        if(cache.containsKey(city)){
            return cache.get(city);
        }else{
            String Weather = externalAPI.getWeather(city);
            cache.put(city, Weather);
            return Weather;
        }
    }

}
