package com.siva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherClient weatherClient;

    @GetMapping("/weather")
    public String getWeatherForCity(@RequestParam String city) {
        return weatherClient.getWeather(city);
    }
}
