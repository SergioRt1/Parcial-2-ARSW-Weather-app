/*
 * Copyright (C) 2016 Pivotal Software, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.example.Weathers.restcontrollers;

import com.example.Weathers.services.WeathersServices;
import com.example.Weathers.services.WeathersServicesException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/weather")
public class WeathersAPIController {

    @Autowired
    WeathersServices services;

    @GetMapping("/{city}")
    public ResponseEntity<?> getWeathersHandler(@PathVariable("city") String city) {
        try {
            return new ResponseEntity<>(services.getWeather(city), HttpStatus.ACCEPTED);
        } catch (WeathersServicesException ex) {
            Logger.getLogger(WeathersServicesException.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error al consultar", HttpStatus.NOT_FOUND);
        }
    }

}
