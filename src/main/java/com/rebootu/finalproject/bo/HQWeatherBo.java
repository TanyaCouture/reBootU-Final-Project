package com.rebootu.finalproject.bo;

import com.rebootu.finalproject.HQWeather;

import java.util.Date;
import java.util.List;

/**
 * Created by tanyacouture on 6/15/15.
 */
public interface HQWeatherBo {

        void save (HQWeather hqWeather);
        void update(HQWeather hqWeather);
        void delete(HQWeather hqWeather);
        HQWeather findByDate(Date date);
        HQWeather findByUid(int uid);
        List<HQWeather> findByDateRange(Date startDate, Date endDate);
        List<HQWeather> findByMonth(Date month);
}
