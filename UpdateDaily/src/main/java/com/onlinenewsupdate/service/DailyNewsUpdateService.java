package com.onlinenewsupdate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlinenewsupdate.dao.DailyNewsUpdateDao;
import com.onlinenewsupdate.model.ArticleModal;
import com.onlinenewsupdate.model.LocationStats;

public interface DailyNewsUpdateService {

	public boolean getLogin(String email, String password);

	  public List<LocationStats> getAllStats();

	public List<ArticleModal> getAllArticle();
	
	

}
