package com.onlinenewsupdate.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinenewsupdate.model.LoginModal;

@Repository
public class DailyNewsUpdateDaoImp implements DailyNewsUpdateDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean getLogin(String email, String password) {
		String hashPassword="";
		
		System.out.println("in dao "+email+""+password);
		Query query=sessionFactory.getCurrentSession().createQuery("from LoginModal where email =:email");
		
		
		query.setParameter("email", email);
		
		Object singleResult = query.getSingleResult();
		
		List<LoginModal> resultList = ((org.hibernate.query.Query) query).list();
		
		for(LoginModal l:resultList)
		{
			System.out.println("passowrd"+l.getPassword());
			hashPassword=l.getPassword();
		}
	
		
		System.out.println("data from dao"+resultList);
		
		if (BCrypt.checkpw(password, hashPassword))
				{
			return true;
				}
		
		
	
		return false;
	}

}
