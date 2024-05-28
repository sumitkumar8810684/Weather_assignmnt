package com.example.weatherappassignment;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("data/2.5/weather")
    Call<WeatherResponse> getWeather(@Query("q") String city, @Query("appid") String apiKey);

    @GET("data/2.5/weather")
    Call<WeatherResponse> getWeatherByLocation(@Query("lat") double latitude, @Query("lon") double longitude, @Query("appid") String apiKey);
}
