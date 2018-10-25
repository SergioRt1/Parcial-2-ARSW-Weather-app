package com.example.Weathers.beans;

import com.example.Weathers.services.WeathersServicesException;

public interface WeathersPersitence {
    
    /**
     * Obtiene los datos del clima de una ciudad desde un api externo o directamente de cache si ya se ha consultado antes, es tolerable a concurrencia. 
     * @param city la ciudad a consultar
     * @return String que representa el JSON de los datos del clima.
     * @throws WeathersServicesException 
     */
    public String getWeather(String city) throws WeathersServicesException;

}
