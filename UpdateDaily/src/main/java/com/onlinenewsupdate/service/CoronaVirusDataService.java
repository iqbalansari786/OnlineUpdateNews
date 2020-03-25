package com.onlinenewsupdate.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.onlinenewsupdate.model.LocationStats;

@Service
public class CoronaVirusDataService {

  

    private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException {
    	
    	System.out.println("thread started..");
        List<LocationStats> newStats = new ArrayList<>();
        String uri="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
	    	RestTemplate rest=new RestTemplate();
		  String result = rest.getForObject(uri, String.class);
		  
		  
		  StringReader csvBodyReader = new StringReader(result);
	        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
       
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.get("Province/State"));
            locationStat.setCountry(record.get("Country/Region"));
         /*   int latestCases = Integer.parseInt(record.get(record.size() - 1));
            int prevDayCases = Integer.parseInt(record.get(record.size() - 2));
            locationStat.setLatestTotalCases(latestCases);
            locationStat.setDiffFromPrevDay(latestCases - prevDayCases);*/
            
            locationStat.setLatestTotalCases(10);
            locationStat.setDiffFromPrevDay(5);
            newStats.add(locationStat);
            
            System.out.println(locationStat.toString());
        }
        this.allStats = newStats;
    }

}