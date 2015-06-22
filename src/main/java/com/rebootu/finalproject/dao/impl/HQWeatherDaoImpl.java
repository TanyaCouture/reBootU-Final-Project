package com.rebootu.finalproject.dao.impl;

import com.rebootu.finalproject.HQWeather;
import com.rebootu.finalproject.dao.CustomHibernateDaoSupport;
import com.rebootu.finalproject.dao.HQWeatherDao;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by tanyacouture on 6/15/15.
 */

@Transactional
@Repository("hqweatherDao")
public class HQWeatherDaoImpl extends CustomHibernateDaoSupport implements HQWeatherDao {

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

    public HQWeather findByUid(int uid){
        List list = getHibernateTemplate().find(
                "from HQWeather where uid=?",uid
        );
        return(HQWeather)list.get(0);
    }

    public List<HQWeather> findByDateRange(Date startDate, Date endDate){
        List list = getHibernateTemplate().find(
                "from HQWeather where date between ? and  ?",
                startDate,
                endDate
        );
        return list;
    }

    // from HQWeather w where month(w.date) = ? and day(w.date) = ?
    // findByMonth currently not developed
    public List<HQWeather> findByMonth(Date date){
        List list = getHibernateTemplate().find(
                "from HQWeather where month(date)=?",
                date

                //could possibly use Calendar to iterate through years
                //parse method defaults at 1970 (when not passed a year
                /*check java.util.date
                Calendar c = Calendar.getInstance();
                c.setTime(fromDate);
                c.set(Calendar.YEAR, 2011);
                fromDate = c.getTime();*/
        );
        return list;
    }

}
