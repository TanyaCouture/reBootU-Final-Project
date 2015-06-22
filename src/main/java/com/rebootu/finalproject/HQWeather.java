package com.rebootu.finalproject;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;

/**
 * Created by tanyacouture on 6/4/15.
 */

/**
 * Weather data from Crater Lake park headquarters
 */
@Entity
@Table(name = "HQWeather")
public class HQWeather extends AbstractEntity {

    private Date date;
    private Double precipitation;
    private Double dailySnowFall;
    private Double snowDepth;
    private Double maxTemp = null;
    private Double minTemp = null;
    /*private Year year;
    private Month month;
    private MonthDay dateNumber;
    private double dayCounted;*/
    private Double accumPrecip;
    private Double accumSnowFall;

    public HQWeather(Date date, Double precipitation, Double dailySnowFall, Double snowDepth, Double maxTemp, Double minTemp, Double accumPrecip, Double accumSnowFall){

        this.date = date;
        this.precipitation = precipitation;
        this.dailySnowFall = dailySnowFall;
        this.snowDepth = snowDepth;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        /*this.year = year;
        this.month = month;
        this.dateNumber = dateNumber;
        this.dayCounted = dayCounted;*/
        this.accumPrecip = accumPrecip;
        this.accumSnowFall = accumSnowFall;
    }

    public HQWeather() {}

    @NotNull
    @Column(name = "date", unique = true, nullable = false)
    public Date getDate() { return date;}
    public void setDate(Date date) { this.date = date; }

    @Column(name = "precipitation", unique = false)
    public Double getPrecipitation() { return precipitation; }
    public void setPrecipitation(Double precipitation) { this.precipitation = precipitation; }

    @Column(name = "daily_snow", unique = false)
    public Double getDailySnowFall() { return dailySnowFall; }
    public void setDailySnowFall(Double dailySnowFall) { this.dailySnowFall = dailySnowFall; }

    @Column(name = "snow_depth", unique = false)
    public Double getSnowDepth() { return snowDepth;}
    public void setSnowDepth(Double snowDepth) { this.snowDepth = snowDepth; }

    @Column(name = "max_temp", unique = false)
    public Double getMaxTemp() { return maxTemp;}
    public void setMaxTemp(Double maxTemp) { this.maxTemp = maxTemp; }

    @Column(name = "min_temp", unique = false)
    public Double getMinTemp() { return minTemp; }
    public void setMinTemp(Double minTemp) { this.minTemp = minTemp; }

    /*@NotNull
    @Column(name = "year", unique = true)
    public Year getYear() { return year; }
    public void setYear(Year year) { this.year = year; }

    @NotNull
    @Column(name = "month", unique = true)
    public Month getMonth() { return month;}
    public void setMonth(Month month) { this.month = month; }

    @NotNull
    @Column(name = "date number", unique = true)
    public MonthDay getDateNumber() { return dateNumber;}
    public void setDateNumber(MonthDay dateNumber) { this.dateNumber = dateNumber; }

    @NotNull
    @Column(name = "julian day", unique = true)
    public double getDayCounted() { return dayCounted; }
    public void setDayCounted(double dayCounted) { this.dayCounted = dayCounted; }*/

    @Column(name = "accum_precip", unique = false)
    public Double getAccumPrecip() { return accumPrecip; }
    public void setAccumPrecip(Double accumPrecip) { this.accumPrecip = accumPrecip; }

    @Column(name = "accum_snow", unique = false)
    public Double getAccumSnowFall() { return accumSnowFall;}
    public void setAccumSnowFall(Double accumSnowFall) { this.accumSnowFall = accumSnowFall; }

    // calculates the average temperature for one day, does it need to throw an exception?
    public Double getDailyAvg(Double minTemp, Double maxTemp){
        if (minTemp == null && maxTemp!=null) {
            return maxTemp;
        }
        if (minTemp != null && maxTemp == null) {
            return minTemp;
        }
        if (minTemp == null && maxTemp == null) {
             return null;
        }
        Double dailyAvg = (double)Math.round((minTemp + maxTemp)/2*10)/10;
            return dailyAvg;
    }

    // calculates the "climate normal" for a longer range of dates
    public static Double getClimateNormal(List<HQWeather>list){
        Double sumAvg = 0.0;
        Double dailyAvg = 0.0;
        int count = 0;
        Double climateNormal = 0.0;
        for(int i = 0; i < list.size(); i++,count++){
            Double mintemp = list.get(i).getMinTemp();
            Double maxtemp = list.get(i).getMaxTemp();

            dailyAvg = list.get(i).getDailyAvg(mintemp, maxtemp);
            if (dailyAvg == null) {
                dailyAvg = 0.0;
                count = count - 1;
            }
            sumAvg = sumAvg + dailyAvg;
        }
        climateNormal = (double)Math.round(sumAvg/count*10)/10;
        return climateNormal;
    }
}
