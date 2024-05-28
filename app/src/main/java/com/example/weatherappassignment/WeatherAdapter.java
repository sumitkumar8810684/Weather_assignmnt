package com.example.weatherappassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<WeatherResponse> weatherList;

    public WeatherAdapter(List<WeatherResponse> weatherList) {
        this.weatherList = weatherList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        holder.bind(weatherList.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public void updateWeather(List<WeatherResponse> weatherList) {
        this.weatherList = weatherList;
        notifyDataSetChanged();
    }

    static class WeatherViewHolder extends RecyclerView.ViewHolder {
        private final TextView temperatureTextView;
        private final TextView humidityTextView;
        private final TextView windSpeedTextView;
        private final TextView weatherConditionTextView;
        private final ImageView weatherIconImageView;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            temperatureTextView = itemView.findViewById(R.id.temperatureTextView);
            humidityTextView = itemView.findViewById(R.id.humidityTextView);
            windSpeedTextView = itemView.findViewById(R.id.windSpeedTextView);
            weatherConditionTextView = itemView.findViewById(R.id.weatherConditionTextView);
            weatherIconImageView = itemView.findViewById(R.id.weatherIconImageView);
        }

        public void bind(WeatherResponse weather) {
            temperatureTextView.setText("Temperature: " + weather.getMain().getTemp() + "°C");
            humidityTextView.setText("Humidity: " + weather.getMain().getHumidity() + "%");
            windSpeedTextView.setText("Wind Speed: " + weather.getWind().getSpeed() + " m/s");
            weatherConditionTextView.setText("Condition: " + weather.getWeather().get(0).getDescription());

            // Set weather icon based on condition
            int weatherIconResource = getWeatherIconResource(weather.getWeather().get(0).getIcon());
            weatherIconImageView.setImageResource(weatherIconResource);
        }

        private int getWeatherIconResource(String iconCode) {
            switch (iconCode) {
                case "01d":
                    return R.drawable.ic_clear_sky_day;
                case "01n":
                    return R.drawable.ic_clear_sky_night;
                case "02d":
                    return R.drawable.ic_few_clouds_day;
                case "02n":
                    return R.drawable.ic_few_clouds_night;
                case "03d":
                case "03n":
                    return R.drawable.ic_few_clouds_day;
                case "04d":
                case "04n":
                    return R.drawable.ic_few_clouds_day;
                case "09d":
                case "09n":
                    return R.drawable.ic_shower_rain;
                case "10d":
                case "10n":
                    return R.drawable.ic_shower_rain;
                case "11d":
                case "11n":
                    return R.drawable.ic_thunderstorm;
                case "13d":
                case "13n":
                    return R.drawable.ic_snow;
                case "50d":
                case "50n":
                    return R.drawable.ic_mist;


            }
            return 0;
        }
    }
}
