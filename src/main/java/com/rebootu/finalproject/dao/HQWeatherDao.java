package com.rebootu.finalproject.dao;

import com.rebootu.finalproject.HQWeather;

import java.util.Date;

/**
 * Created by tanyacouture on 6/15/15.
 */
public interface HQWeatherDao {
        void save(HQWeather hqWeather);
        void update(HQWeather hqWeather);
        void delete(HQWeather hqWeather);
        HQWeather findByDate(Date date);
}
