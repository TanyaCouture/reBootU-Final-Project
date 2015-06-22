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
 * Created by tanyacouture on 6/18/15.
 * Chart Practice: Plots temperatures by range of dates
 */

public class ChartDateRange extends Application {

    @Override
    public void start(Stage stage){
        stage.setTitle("Chart Date Range");
        // defining the axes
        final NumberAxis xAxis = new NumberAxis(1, 31, 1);
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        xAxis.setTickUnit(1);
        xAxis.setMinorTickCount(0);
        // creating the chart
        final LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("January 1931 Max Temps");
        // defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("January 1931");

        // populating the series with data
        //create instance of hqWeatherBo
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("spring-config.xml");
        HQWeatherBo hqWeatherBo = (HQWeatherBo)appContext.getBean("HQWeatherBo");

        String dateString = "01/01/1931";
        String dateString2 = "02/01/1931";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
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
            Double temp4 = query4.get(i).getMaxTemp();
            series.getData().add(new XYChart.Data(i, temp4));
        }

        Scene scene = new Scene(lineChart, 900, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}