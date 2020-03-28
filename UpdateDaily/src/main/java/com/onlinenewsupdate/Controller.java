package com.onlinenewsupdate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinenewsupdate.model.ArticleModal;
import com.onlinenewsupdate.model.LocationStats;
import com.onlinenewsupdate.model.LoginModal;
import com.onlinenewsupdate.service.DailyNewsUpdateService;

@org.springframework.stereotype.Controller

public class Controller {
	@Autowired
	private DailyNewsUpdateService dailynewsService;

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView home(Model theModel, HttpServletRequest request) throws NullPointerException {
		theModel.addAttribute("userattribute", new LoginModal());
		System.out.println("home controller called");
		theModel.addAttribute("title", "DashBoard");

		theModel.addAttribute("userClickedlogin", false);
		theModel.addAttribute("userClicked", "BelalSoft");

		return new ModelAndView("index");
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("userattribute")LoginModal user,BindingResult bindingResult, Model model) {

		model.addAttribute("title", "DashBoard");
		
		if(bindingResult.hasErrors())
		{
			
			System.out.println("something is wrong in binding");
			model.addAttribute("userClickedlogin", false);
			
			model.addAttribute("userClickedloginmsg", "sorry you have not enterd your email and password..");
			return "index";
			
		}

	

		
			
			boolean result=dailynewsService.getLogin(user.getEmail(),user.getPassword());
			if(result ==  true)
			{
				model.addAttribute("userClickedlogin", true);
				model.addAttribute("userClickedloginmsg", "Successfully logged in.");
				System.out.println("user enter" + user.getEmail());	
			}
			else
			{
				model.addAttribute("userClickedlogin", false);

				model.addAttribute("userClickedloginmsg", "sorry you have not enterd your email and password..");
				
			}
			
			
			

		

		return "index";

	}

	@PostMapping("/loginwithgoogle")
	public String loginwithgoogle(HttpServletRequest request, Model model) {

		model.addAttribute("title", "DashBoard");

		String email = request.getParameter("emailId");

		model.addAttribute("userClickedlogin", true);
		System.out.println("user enter" + email);

		return "index";

	}
	
	
	@RequestMapping("/crona")
	
	public ModelAndView cronaCateogry(Model model)
	{   
		
		List<LocationStats> allStats = dailynewsService.getAllStats();
		for(LocationStats l:allStats)
		{
			System.out.println("data"+l.toString());
		}
		
		model.addAttribute("userattribute", new LoginModal());
		model.addAttribute("userClickedCrona",true);
		model.addAttribute("cronaStatus",allStats);
		
		return new ModelAndView("index");
	}
	
	
@RequestMapping("/article")
	
	public ModelAndView article(Model model)
	{   
	String keyword = "マイナー、マイニングしたビットコインよりも多くのビットコインを売却";
	String keyword1="Быстрый и выгодный обмен bitcoin на яндекс деньги";
	Boolean found =false;
	int count=0;

	model.addAttribute("userattribute", new LoginModal());
		
		List<ArticleModal> allStats = dailynewsService.getAllArticle();
		Iterator<ArticleModal> iterator = allStats.iterator();
		
		while(iterator.hasNext())
		{
			
	String title=iterator.next().getTitle();
	 if (title.contains(keyword) || title.contains(keyword1)) {
		 count++;
    	 System.out.println("title with quest"+title+""+count);
     }
	   
	     else
	     {
	    	 model.addAttribute("article",title);
			System.out.println("iterating in with out question controller"+iterator.next().getTitle());
	     }
			
			
		}

		
	
		model.addAttribute("userClickedArticle",true);
	    model.addAttribute("article",allStats);
		
		return new ModelAndView("index");
	}
	
/*private boolean isContainExactWord(String fullString, String partWord){
    String pattern = "\\b"+partWord+"\\b";
    Pattern p=Pattern.compile(pattern);
    Matcher m=p.matcher(fullString);
    return m.find();
}*/


}
