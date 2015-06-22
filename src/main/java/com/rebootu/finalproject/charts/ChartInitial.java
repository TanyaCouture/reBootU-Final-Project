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

/**
 * Created by tanyacouture on 6/16/15.
 * Chart practice: plots temperatures by uid
 */
public class ChartInitial extends Application {

    @Override
    public void start(Stage stage){
        stage.setTitle("Chart Initial");
        // defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Sample Number");
        // creating the chart
        final LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("A Few Max Temps, 1931");
        // defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("January 1931");

        // populating the series with data
        //create instance of hqWeatherBo
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("spring-config.xml");
        HQWeatherBo hqWeatherBo = (HQWeatherBo)appContext.getBean("HQWeatherBo");

        // while uid is less than 10, add data
        for(int i = 1; i < 11; i++) {
            HQWeather queryInit = hqWeatherBo.findByUid(i);
            Double temp = queryInit.getMaxTemp();

            series.getData().add(new XYChart.Data(i, temp));
        }
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
}

    public static void main(String[] args){
        launch(args);
    }

}