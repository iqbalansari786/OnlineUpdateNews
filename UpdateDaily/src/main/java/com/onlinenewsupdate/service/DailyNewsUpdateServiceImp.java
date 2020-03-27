package com.onlinenewsupdate.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.onlinenewsupdate.dao.DailyNewsUpdateDao;

@Service
public class DailyNewsUpdateServiceImp implements DailyNewsUpdateService{
	
	@Autowired
	private  DailyNewsUpdateDao dailynewsdaoImp;

	@Transactional
	@Override
	public boolean getLogin(String email, String password) {
		
		return dailynewsdaoImp.getLogin(email,password);
	}

}
