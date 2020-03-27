package com.onlinenewsupdate.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlinenewsupdate.dao.DailyNewsUpdateDao;

public interface DailyNewsUpdateService {

	boolean getLogin(String email, String password);
	
	

}
