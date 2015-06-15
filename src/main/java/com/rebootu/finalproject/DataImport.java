package com.rebootu.finalproject;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DataImport extends HQWeather{

    //String import;

   // public DataImport(){}

    public static void main(String[] args) throws Exception{
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("spring-config.xml");

        // gets CSV file
        FileReader in = new FileReader("/Users/tanyacouture/Desktop/hq_data.csv");
        CSVParser parser = new CSVParser(in, CSVFormat.EXCEL);
        List<CSVRecord> list = parser.getRecords();

        // prints all data in table by row
        for (CSVRecord record : list) {

            HQWeather weather = new HQWeather();

            String dateString = record.get(0);
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);
            Date date = format.parse(dateString);
            //System.out.println(date);
            weather.setDate(date);

            String precipString = record.get(1);
            if(!precipString.isEmpty()){
                double precip = Double.valueOf(precipString);
                // System.out.println(precip);
                weather.setPrecipitation(precip);
            }

            // string daily snow to float
            String snowFallString = record.get(2);
            if(!snowFallString.isEmpty()) {
                double dailySnowFall = Double.valueOf(snowFallString);
               // System.out.println(dailySnowFall);
                weather.setDailySnowFall(dailySnowFall);
            }

            // string snow depth to float
            String snowDepthString = record.get(3);
            if(!snowDepthString.isEmpty()) {
                double snowDepth = Double.valueOf(snowDepthString);
                //System.out.println(snowDepth);
                weather.setSnowDepth(snowDepth);
            }

            // string max temp to float
            String maxTempString = record.get(4);
            if(!maxTempString.isEmpty()) {
                double maxTemp = Double.valueOf(maxTempString);
                //System.out.println(maxTemp);
                weather.setMaxTemp(maxTemp);
            }

            // string min temp to float
            String mintempString = record.get(5);
            if(!mintempString.isEmpty() && !mintempString.equals("no data")) {
                double minTemp = Double.valueOf(mintempString);
                //System.out.println(minTemp);
                weather.setMinTemp(minTemp);
            }

            // string accumPrecip to double
            String accumPrecipString = record.get(10);
            if(!accumPrecipString.isEmpty() && !accumPrecipString.equals("no data")) {
                double accumPrecip = Double.valueOf(accumPrecipString);
                //System.out.println(accumPrecip);
                weather.setAccumPrecip(accumPrecip);
            }

            // string accumSnowFall to double
            String accumSnowString = record.get(11);
            if(!accumSnowString.isEmpty() && !accumSnowString.equals("no data")) {
                double accumSnowFall = Double.valueOf(accumSnowString);
                //System.out.println(accumSnowFall);
                weather.setAccumSnowFall(accumSnowFall);
            }

        }

        System.out.println("Data Imported");

    }
}
