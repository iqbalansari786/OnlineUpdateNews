package com.onlinenewsupdate;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		
		String hashPassword = hashPassword("sonu");
		System.out.println("hashed pasword"+hashPassword);
		checkPass("sonua", "$2a$10$xkY9CMyTfc8fBrPq7sP0weXcIKPMAlZfKMIvKC4tXCr4dik3WFF1a");
		
	
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
