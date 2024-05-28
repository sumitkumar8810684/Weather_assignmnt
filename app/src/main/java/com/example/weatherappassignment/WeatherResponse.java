package com.example.weatherappassignment;

import java.util.List;

public class WeatherResponse {
    private Main main;
    private Wind wind;
    private List<Weather> weather;

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public class Main {
        private float temp;
        private int humidity;

        public float getTemp() {
            return temp;
        }

        public int getHumidity() {
            return humidity;
        }
    }

    public class Wind {
        private float speed;

        public float getSpeed() {
            return speed;
        }
    }

    public class Weather {
        private String description;
        private String icon;

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }
}
