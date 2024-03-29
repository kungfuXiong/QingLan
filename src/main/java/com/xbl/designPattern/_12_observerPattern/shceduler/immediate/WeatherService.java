package com.xbl.designPattern._12_observerPattern.shceduler.immediate;

import com.xbl.designPattern._12_observerPattern.weather.ImmediateWeather;
import com.xbl.designPattern._12_observerPattern.weather.WeatherPush;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    public void sendWeather(){
        WeatherPush weatherPush = new WeatherPush();
        weatherPush.attach(new ImmediateWeather("320105"));
        weatherPush.attach(new ImmediateWeather("320111"));
        weatherPush.notifyAllSubscribers();
    }

}
