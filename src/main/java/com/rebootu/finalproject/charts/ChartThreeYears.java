package com.rebootu.finalproject.charts;

import com.rebootu.finalproject.HQWeather;
import com.rebootu.finalproject.bo.HQWeatherBo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by tanyacouture on 6/22/15.
 */
public class ChartThreeYears extends Application {

    @Override
    public void start(Stage stage){
        stage.setTitle("Average Temperatures for 3 years");
        // defining the axes
        final NumberAxis xAxis = new NumberAxis(0, 365, 1);
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Day number of the year");
        xAxis.setTickUnit(5);
        xAxis.setMinorTickCount(0);
        // creating the chart
        final LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Daily Average Temperatures for 3 Years");

        // populating the series with data
        //create instance of hqWeatherBo
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("spring-config.xml");
        HQWeatherBo hqWeatherBo = (HQWeatherBo)appContext.getBean("HQWeatherBo");

        // defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("1931");

        String dateString = "01/01/1931";
        String dateString2 = "12/31/1931";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date startDate = null;
        Date endDate = null;

        try {
            startDate = format.parse(dateString);
            endDate = format.parse(dateString2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<HQWeather> query31 = hqWeatherBo.findByDateRange(startDate, endDate);
        for(int i = 0; i < query31.size(); i++) {
            Double tempMax = query31.get(i).getMaxTemp();
            Double tempMin = query31.get(i).getMinTemp();
            Double avgTemp = query31.get(i).getDailyAvg(tempMin,tempMax);
            //int getDate = query31.get(i).getDate().getMonth();

            if(avgTemp == null){
                continue;
            }

            series.getData().add(new XYChart.Data(i, avgTemp));
        }

        // defining a series
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("1989");

        String dateString3 = "01/01/1989";
        String dateString4 = "12/31/1989";
        //SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date startDate3 = null;
        Date endDate3 = null;

        try {
            startDate3 = format.parse(dateString3);
            endDate3 = format.parse(dateString4);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<HQWeather> query89 = hqWeatherBo.findByDateRange(startDate3, endDate3);
        for(int j = 0; j < query89.size(); j++) {
            Double tempMax = query89.get(j).getMaxTemp();
            Double tempMin = query89.get(j).getMinTemp();
            Double avgTemp = query89.get(j).getDailyAvg(tempMin,tempMax);
            //int getDate = query89.get(j).getDate().getMonth();

            if(avgTemp == null){
                continue;
            }

            series1.getData().add(new XYChart.Data(j, avgTemp));
        }

        // defining a series
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2012");

        String dateString5 = "01/01/2012";
        String dateString6 = "12/31/2012";
        //SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date startDate5 = null;
        Date endDate5 = null;

        try {
            startDate3 = format.parse(dateString5);
            endDate3 = format.parse(dateString6);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<HQWeather> query12 = hqWeatherBo.findByDateRange(startDate3, endDate3);
        for(int k = 0; k < query12.size(); k++) {
            Double tempMax = query12.get(k).getMaxTemp();
            Double tempMin = query12.get(k).getMinTemp();
            Double avgTemp = query12.get(k).getDailyAvg(tempMin,tempMax);
            //int getDate = query12.get(j).getDate().getMonth();

            if(avgTemp == null){
                continue;
            }

            series2.getData().add(new XYChart.Data(k, avgTemp));
        }

        Scene scene = new Scene(lineChart, 1500, 600);
        lineChart.getData().add(series);
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}
