package com.onlinenewsupdate;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.client.RestTemplate;

import com.onlinenewsupdate.model.LocationStats;



public class RestClient {
	public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException
	{
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=null;
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dailynewsupdate", "dailynewsupdate");
		if(con!=null)
		{
			System.out.println("connected");
		}
		else
		{
			System.out.println("not connected");
		}
		*/
		
/*		String hashPassword = hashPassword("sonu");
		System.out.println("hashed pasword"+hashPassword);
		checkPass("sonua", "$2a$10$xkY9CMyTfc8fBrPq7sP0weXcIKPMAlZfKMIvKC4tXCr4dik3WFF1a");*/
		
	   List<LocationStats> allStats = new ArrayList<>();
	   List<LocationStats> newStats = new ArrayList<>();
		
	RestTemplate re=new RestTemplate();
	String forObject = re.getForObject("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/01-22-2020.csv", String.class);
	System.out.println(forObject.toString());
	
	
    StringReader csvBodyReader = new StringReader(forObject);
    Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
    for (CSVRecord record : records) {
    	System.out.println(record);
    	
    /*	
        LocationStats locationStat = new LocationStats();
        locationStat.setState(record.get("Province/State"));
        locationStat.setCountry(record.get("Country/Region"));
        int latestCases = Integer.parseInt(record.get(record.size() - 1));
        int prevDayCases = Integer.parseInt(record.get(record.size() - 2));
        locationStat.setLatestTotalCases(latestCases);
        locationStat.setDiffFromPrevDay(latestCases - prevDayCases);
        newStats.add(locationStat);
        
        System.out.println(locationStat.toString());*/
    }
 


  
	
	}
	
			
	
	public static String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	public static  void checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			System.out.println("The password matches.");
		else
			System.out.println("The password does not match.");
	}

}
