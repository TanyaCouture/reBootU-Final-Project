package com.rebootu.finalproject;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.util.Date;

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
    private double precipitation;
    private double dailySnowFall;
    private double snowDepth;
    private double maxTemp;
    private double minTemp;
    private Year year;
    private Month month;
    private MonthDay dateNumber;
    private double dayCounted;
    private double accumPrecip;
    private double accumSnowFall;

    public HQWeather(Date date, double precipitation, double dailySnowFall, double snowDepth, double maxTemp, double minTemp, double accumPrecip, double accumSnowFall){

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
    public double getPrecipitation() { return precipitation; }
    public void setPrecipitation(double precipitation) { this.precipitation = precipitation; }

    @Column(name = "daily_snow", unique = false)
    public double getDailySnowFall() { return dailySnowFall; }
    public void setDailySnowFall(double dailySnowFall) { this.dailySnowFall = dailySnowFall; }

    @Column(name = "snow_depth", unique = false)
    public double getSnowDepth() { return snowDepth;}
    public void setSnowDepth(double snowDepth) { this.snowDepth = snowDepth; }

    @Column(name = "max_temp", unique = false)
    public double getMaxTemp() { return maxTemp;}
    public void setMaxTemp(double maxTemp) { this.maxTemp = maxTemp; }

    @Column(name = "min_temp", unique = false)
    public double getMinTemp() { return minTemp; }
    public void setMinTemp(double minTemp) { this.minTemp = minTemp; }

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
    public double getAccumPrecip() { return accumPrecip; }
    public void setAccumPrecip(double accumPrecip) { this.accumPrecip = accumPrecip; }

    @Column(name = "accum_snow", unique = false)
    public double getAccumSnowFall() { return accumSnowFall;}
    public void setAccumSnowFall(double accumSnowFall) { this.accumSnowFall = accumSnowFall; }
}
