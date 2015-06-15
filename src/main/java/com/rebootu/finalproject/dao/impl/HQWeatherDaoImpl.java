package com.rebootu.finalproject.dao.impl;

import com.rebootu.finalproject.HQWeather;
import com.rebootu.finalproject.dao.HQWeatherDao;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by tanyacouture on 6/15/15.
 */

@Repository("hqweatherDao")
public class HQWeatherDaoImpl extends CustomHibernateDaoSupport implements HQWeatherDao{

    public void save(HQWeather hqWeather){
        getHibernateTemplate().save(hqWeather);
    }

    public void update(HQWeather hqWeather){
        getHibernateTemplate().update(hqWeather);
    }

    public void delete(HQWeather hqWeather){
        getHibernateTemplate().delete(hqWeather);
    }

    public HQWeather findByDate(Date date){
        List list = getHibernateTemplate().find(
                "from HQWeather where date=?",date
        );
        return(HQWeather)list.get(0);
    }
}
