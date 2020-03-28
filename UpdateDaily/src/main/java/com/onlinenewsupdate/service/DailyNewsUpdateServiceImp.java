package com.onlinenewsupdate.service;



import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.onlinenewsupdate.dao.DailyNewsUpdateDao;
import com.onlinenewsupdate.model.ArticleModal;
import com.onlinenewsupdate.model.LocationStats;

@Service

public class DailyNewsUpdateServiceImp implements DailyNewsUpdateService{
	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/01-22-2020.csv";
	private static String ARTICLE_DATA_URL="http://newsapi.org/v2/everything?q=bitcoin&from=2020-02-28&sortBy=publishedAt&apiKey=a1fd3224aa5f4293a59960abf3fa539c";
    private List<LocationStats> allStats = new ArrayList<>();
    
    private List<ArticleModal> articleStats = new ArrayList<>();
	@Autowired
	private  DailyNewsUpdateDao dailynewsdaoImp;

	@Transactional
	@Override
	public boolean getLogin(String email, String password) {
		
		return dailynewsdaoImp.getLogin(email,password);
	}
	


    public List<LocationStats> getAllStats() {
    	
    	
        return allStats;
    }
    
    @Override
	public List<ArticleModal> getAllArticle() {
		// TODO Auto-generated method stub
		return articleStats;
	}
	

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException {
    	
    	System.out.println("started...");
        List<LocationStats> newStats = new ArrayList<>();
        RestTemplate re=new RestTemplate();
    	String forObject = re.getForObject(VIRUS_DATA_URL, String.class);
    	
    	
    	
        StringReader csvBodyReader = new StringReader(forObject);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.get(0));
            locationStat.setCountry(record.get(1));
            locationStat.setLastUpdate(record.get(2));
            locationStat.setConfirmed(record.get(3));
            locationStat.setDeath(record.get(4));
            locationStat.setRecovered(record.get(5));
            
          
           
            newStats.add(locationStat);
        }
        this.allStats = newStats;
    }


    
    @PostConstruct
    public void fetchArticleData() throws IOException, InterruptedException {
    	
    	System.out.println("started... for article");
        List<ArticleModal> article = new ArrayList<>();
        RestTemplate re=new RestTemplate();
    	String forObject = re.getForObject(ARTICLE_DATA_URL, String.class);
    	
    
        JSONObject jsonObject = new JSONObject(forObject);
		  List<ArticleModal> list = new ArrayList<ArticleModal>();
	      JSONArray jsonArray = jsonObject.getJSONArray("articles");
	     
	      for(int i = 0 ; i < jsonArray.length(); i++) {
	    	  ArticleModal articleValue =new ArticleModal();
		    	articleValue.setPublishedAt((String) jsonArray.getJSONObject(i).get("publishedAt"));
		    	articleValue.setAuthor(jsonArray.getJSONObject(i).get("author"));
		    	articleValue.setUrlToImage(jsonArray.getJSONObject(i).get("urlToImage"));
		    	
		    	
		    	articleValue.setTitle(jsonArray.getJSONObject(i).getString("title"));
		    	
		    	articleValue.setContent(jsonArray.getJSONObject(i).getString("content"));
		
	     
		
	       article.add(articleValue);
	       }
			    
        
        
        
        this.articleStats = article;
    }


	
	
	

}
