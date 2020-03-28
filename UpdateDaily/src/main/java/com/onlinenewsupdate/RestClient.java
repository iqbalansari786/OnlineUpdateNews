package com.onlinenewsupdate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpResponse;
import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.validation.Errors;
import org.springframework.web.client.RestTemplate;


import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.onlinenewsupdate.model.ArticleModal;
import com.onlinenewsupdate.model.LocationStats;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;




public class RestClient {
	public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException, UnirestException
	
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
	/*		
		try {


	 com.mashape.unirest.http.HttpResponse<JsonNode> asJson = Unirest.get("https://lexper.p.rapidapi.com/v1.1/extract?media=1&url=https%253A%252F%252Fmedium.com%252Fpersonal-growth%252Fhow-to-be-yourself-2221085391a3")
					.header("x-rapidapi-host", "lexper.p.rapidapi.com")
					.header("x-rapidapi-key", "b280780b4amshd80a7c588c089a8p18adafjsn641220f141ad")
					.asJson();
			
		
		    	    System.out.println(asJson.getStatus());

		 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
	
		ArticleModal ar=new ArticleModal();
		RestTemplate re=new RestTemplate();
		String forObject = re.getForObject("http://newsapi.org/v2/everything?q=bitcoin&from=2020-02-28&sortBy=publishedAt&apiKey=a1fd3224aa5f4293a59960abf3fa539c",String.class);
		
		/*  JSONObject jsonObject = new JSONObject(forObject);
		  List<ArticleModal> list = new ArrayList<ArticleModal>();
	      JSONArray jsonArray = jsonObject.getJSONArray("articles");*/
	      
	    
	      
				
			
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
	    	System.out.println("article "+articleValue.toString());
	     
		
	     
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
