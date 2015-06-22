package com.rebootu.finalproject;

import com.rebootu.finalproject.bo.HQWeatherBo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by tanyacouture on 6/16/15.
 * Testing HQL queries
 */
public class QuerySandbox {

    public static void main(String[] args){
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("spring-config.xml");

        HQWeatherBo hqWeatherBo = (HQWeatherBo)appContext.getBean("HQWeatherBo");

        HQWeather query1 = hqWeatherBo.findByUid(1);
        //System.out.println(query1);

        HQWeather query2 = hqWeatherBo.findByUid(1);
        Double temp = query2.getMaxTemp();
        //System.out.println(temp);

        String dateString = "01/01/1931";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        HQWeather query3 = hqWeatherBo.findByDate(date);
        Double temp3 = query3.getMaxTemp();
        //System.out.println(temp3);


        // get month and year of date
        String dateString2 = "01/30/1931";
        Date startDate = null;
        Date endDate = null;

        try {
            startDate = format.parse(dateString);
            endDate = format.parse(dateString2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<HQWeather> query4 = hqWeatherBo.findByDateRange(startDate, endDate);
        for(int i = 0; i < query4.size(); i++) {
            Date dateOut = query4.get(i).getDate();
            Double temp4 = query4.get(i).getMaxTemp();
           // System.out.println(dateOut);
           // System.out.println(temp4);
        }

        //get all Januaries


        String dateString4 = "01/01/1931";
        SimpleDateFormat format5 = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date startDate4 = null;

        try {
            startDate4 = format5.parse(dateString4);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<HQWeather> query6 = hqWeatherBo.findByMonth(startDate4);
        for(int i = 0; i < query6.size(); i++) {
            Date dateOut6 = query6.get(i).getDate();
            Double temp6 = query6.get(i).getMaxTemp();
            System.out.println(dateOut6);
            System.out.println(temp6);
        }



    }
}

