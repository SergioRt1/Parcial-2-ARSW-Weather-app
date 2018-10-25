/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Weathers.services;

import java.util.Collection;
import java.util.Set;

/**
 *
 * @author hcadavid
 */
public interface WeathersServices {
    
    /**
     * Obtiene los datos del clima de una ciudad.
     * @param city la ciudad a consultar
     * @return String que representa el JSON de los datos del clima.
     * @throws WeathersServicesException 
     */
    String getWeather(String city) throws WeathersServicesException;
    
}
