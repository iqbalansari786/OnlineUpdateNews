package com.onlinenewsupdate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.onlinenewsupdate.model.LocationStats;
import com.onlinenewsupdate.service.CoronaVirusDataService;

@org.springframework.stereotype.Controller
public class Controller {

	    CoronaVirusDataService coronaVirusDataService=new CoronaVirusDataService();
	
	@RequestMapping(value= {"/","/home"})
	public ModelAndView home(Model theModel,HttpServletRequest request)throws NullPointerException
	{
		
	
	
		System.out.println("home controller called");
		theModel.addAttribute("title", "DashBoard");
		
		theModel.addAttribute("userClickedlogin",false);
	
		
		
		return new ModelAndView("index");
	}
	
	


	    @GetMapping("/crona")
	    public String crona(Model model) {
	    	
	    	model.addAttribute("title","crona latest news");
	    	
	    	model.addAttribute("userClickedCrona",true);
	        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
	        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
	        
	        System.out.println("total cases"+totalReportedCases);
	        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
	        
	        System.out.println("total new CASE"+totalNewCases);
	        model.addAttribute("locationStats", allStats);
	        model.addAttribute("totalReportedCases", totalReportedCases);
	        model.addAttribute("totalNewCases", totalNewCases);
	        return "index";
	       
	    }
	    
	    
	    @PostMapping("/login")
	    public String login(HttpServletRequest request,Model model) {
	    	
	    	model.addAttribute("title","DashBoard");
	    	
	    	
	    	
	    	String email=request.getParameter("email");
	    	String password=request.getParameter("password");
	    	
	    	if(email.isEmpty()||password.isEmpty())
	    	{
	    		model.addAttribute("userClickedlogin",false);
	    		
	    		model.addAttribute("userClickedloginmsg","sorry you have not enterd your email and password..");
	    	}
	    	else
	    	{
	    		model.addAttribute("userClickedlogin",true);
	    		System.out.println("user enter"+email);
	    		
	    	}
	     
	        return "index";
	       
	    }
	    @PostMapping("/loginwithgoogle")
	    public String loginwithgoogle(HttpServletRequest request,Model model) {
	    	
	    	model.addAttribute("title","DashBoard");
	    	
	    	
	    	
	    	String email=request.getParameter("emailId");
	   
	    	
	   
	    	
	    		model.addAttribute("userClickedlogin",true);
	    		System.out.println("user enter"+email);
	    		
	    	
	     
	        return "index";
	       
	    }
	    


}
