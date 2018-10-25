package com.example.Weathers.beans;

import com.example.Weathers.services.WeathersServicesException;

public interface WeathersPersitence {

    public String getWeather(String city) throws WeathersServicesException;

}
