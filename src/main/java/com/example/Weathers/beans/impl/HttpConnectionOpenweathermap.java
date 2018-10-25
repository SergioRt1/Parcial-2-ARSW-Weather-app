/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Weathers.beans.impl;

import com.example.Weathers.beans.HttpConnection;
import com.example.Weathers.services.WeathersServicesException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergio
 */
@Service
public class HttpConnectionOpenweathermap implements HttpConnection {

    private final String USER_AGENT = "Mozilla/5.0";
    private final String APIkey = "1bc453b8f8fc960bd986e3dd5ad83f5b";

    @Override
    public String getWeather(String city) throws WeathersServicesException {
        String GET_URL = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&APPID=%s", city, APIkey);
        try {

            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                return response.toString();

            } else {
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
            throw new WeathersServicesException("Error consultando al API externo.");
        } catch (IOException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new WeathersServicesException("Error consultando al API externo.");
        }
    }
}
