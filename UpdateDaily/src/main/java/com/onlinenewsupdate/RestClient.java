package com.onlinenewsupdate;

import java.io.IOException;
import java.io.StringReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.client.RestTemplate;

import com.onlinenewsupdate.model.LocationStats;

public class RestClient {
	public static void main(String args[]) throws IOException
	{
		String uri="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
		RestTemplate rest=new RestTemplate();
		  String result = rest.getForObject(uri, String.class);
		  
		  
		  StringReader csvBodyReader = new StringReader(result);
	        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
	        for (CSVRecord record : records) {
	            LocationStats locationStat = new LocationStats();
	            locationStat.setState(record.get("Province/State"));
	            locationStat.setCountry(record.get("Country/Region"));
	            int latestCases = Integer.parseInt(record.get(record.size() - 1));
	            int prevDayCases = Integer.parseInt(record.get(record.size() - 2));
	            locationStat.setLatestTotalCases(latestCases);
	            locationStat.setDiffFromPrevDay(latestCases - prevDayCases);
	            System.out.println(locationStat.toString());
	           
	        }
	
	}

}
