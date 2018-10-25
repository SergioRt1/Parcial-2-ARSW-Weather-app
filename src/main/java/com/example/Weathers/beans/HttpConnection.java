/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Weathers.beans;

import com.example.Weathers.services.WeathersServicesException;

/**
 *
 * @author sergio
 * Se encarga de realizar la coneccion con los api externos.
 */
public interface HttpConnection {
    
    /**
     * Obtiene los datos del clima de una ciudad desde un api externo.
     * @param city la ciudad a consultar
     * @return String que representa el JSON de los datos del clima.
     * @throws WeathersServicesException 
     */
    public String getWeather(String city) throws WeathersServicesException;
    
}
