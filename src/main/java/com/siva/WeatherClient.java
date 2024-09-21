package com.siva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;

@Component
public class WeatherClient {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "201a066056964fc776029aef08adf9c7"; // Replace with your OpenWeatherMap API key

    public String getWeather(String city) {
        StringBuilder result = new StringBuilder();
        try {
            String urlStr = String.format("%s?q=%s&appid=%s&units=metric", "https://api.openweathermap.org/data/2.5/weather", city, "201a066056964fc776029aef08adf9c7");
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            // Parse JSON response using Gson
            JsonObject jsonObject = JsonParser.parseString(result.toString()).getAsJsonObject();
            String temp = jsonObject.getAsJsonObject("main").get("temp").getAsString();
            String description = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();

            return "Temperature: " + temp + "°C, Weather: " + description;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching weather data.";
        }
    }
}
