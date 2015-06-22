package com.rebootu.finalproject;

import com.rebootu.finalproject.bo.HQWeatherBo;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by tanyacouture on 6/19/15.
 */
public class FinalProjectTests extends TestCase {
    @Test
    public void testAverages(){
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("spring-config.xml");

        HQWeatherBo hqWeatherBo = (HQWeatherBo)appContext.getBean("HQWeatherBo");

        // test average for one day, tests getDailyAvg()
        String dateString = "01/01/1931";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        HQWeather query1 = hqWeatherBo.findByDate(date);
        double maxtemp1 = query1.getMaxTemp();
        double mintemp1 = query1.getMinTemp();

        double day1 = query1.getDailyAvg(mintemp1, maxtemp1);
        assertEquals(35.0, day1);

        // test climate normal over a change in year and month, tests getClimateNormal
        String dateStringStart = "12/27/1931";
        String dateStringEnd = "01/06/1932";
        Date startDate2 = null;
        Date endDate2 = null;
        try {
            startDate2 = format.parse(dateStringStart);
            endDate2 = format.parse(dateStringEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<HQWeather> list1 = hqWeatherBo.findByDateRange(startDate2, endDate2);
        double normal1 = HQWeather.getClimateNormal(list1);
        assertEquals(25.7, normal1);

        //print average temps for 1 year
        String dateString8 = "01/01/1931";
        String dateString9 = "12/31/1931";
        SimpleDateFormat format8 = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date startDate8 = null;
        Date endDate8 = null;

        try {
            startDate8 = format.parse(dateString8);
            endDate8 = format.parse(dateString9);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<HQWeather> query4 = hqWeatherBo.findByDateRange(startDate8, endDate8);
        for(int i = 0; i < query4.size(); i++) {
            Double tempMax = query4.get(i).getMaxTemp();
            Double tempMin = query4.get(i).getMinTemp();
            Double avgTemp = query4.get(i).getDailyAvg(tempMin,tempMax);
            Date getDate = query4.get(i).getDate();
            // System.out.println(getDate);
            // System.out.println(avgTemp);
        }

        // daily average for a different period of time
        // test climate normal over a change in year and month, tests getClimateNormal
        String dateStringStart20 = "01/01/1931";
        String dateStringEnd20 = "12/31/1931";
        Date startDate20 = null;
        Date endDate20 = null;
        try {
            startDate20 = format.parse(dateStringStart20);
            endDate20 = format.parse(dateStringEnd20);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<HQWeather> list20 = hqWeatherBo.findByDateRange(startDate20, endDate20);
        Double normal20 = HQWeather.getClimateNormal(list20);
        System.out.println(normal20);




    }
}
