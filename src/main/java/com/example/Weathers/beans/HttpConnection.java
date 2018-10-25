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
    
    public String getWeather(String city) throws WeathersServicesException;
    
}
