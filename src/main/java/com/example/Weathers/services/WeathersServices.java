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

    String getWeather(String city) throws WeathersServicesException;
    
}
