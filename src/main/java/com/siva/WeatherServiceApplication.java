package com.siva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class WeatherServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeatherServiceApplication.class, args);

        // Prompt user for city input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the city name: ");
        String city = scanner.nextLine();

        // Fetch weather information
        WeatherClient weatherClient = new WeatherClient();
        String weatherData = weatherClient.getWeather(city);

        // Display the weather information
        System.out.println(weatherData);

        scanner.close();
    }
}
