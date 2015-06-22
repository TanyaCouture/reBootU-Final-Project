package com.rebootu.finalproject.bo.impl;

import com.rebootu.finalproject.HQWeather;
import com.rebootu.finalproject.bo.HQWeatherBo;
import com.rebootu.finalproject.dao.HQWeatherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by tanyacouture on 6/15/15.
 */

@Service("HQWeatherBo")
public class HQWeatherBoImpl implements HQWeatherBo{

    @Autowired
    HQWeatherDao hqWeatherDao;

    public void setHqWeatherDao(HQWeatherDao hqWeatherDao){
        this.hqWeatherDao = hqWeatherDao;
    }

    public void save(HQWeather hqWeather){
        hqWeatherDao.save(hqWeather);
    }

    public void update(HQWeather hqWeather){
        hqWeatherDao.update(hqWeather);
    }

    public void delete(HQWeather hqWeather){
        hqWeatherDao.delete(hqWeather);
    }

    public HQWeather findByDate(Date date){
        return hqWeatherDao.findByDate(date);
    }

    public HQWeather findByUid(int uid) { return hqWeatherDao.findByUid(uid); }

    public List<HQWeather> findByDateRange(Date startDate, Date endDate) { return hqWeatherDao.findByDateRange(startDate, endDate); }

    public List<HQWeather> findByMonth(Date month) { return hqWeatherDao.findByMonth(month); }
}

