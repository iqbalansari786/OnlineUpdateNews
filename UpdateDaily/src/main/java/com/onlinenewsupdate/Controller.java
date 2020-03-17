package com.onlinenewsupdate;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
	
	
	@RequestMapping(value= {"/","/home"})
	public ModelAndView home(Model theModel)
	{
		theModel.addAttribute("userClickedHome", "DashBoard");
		
		return new ModelAndView("index");
	}

}
