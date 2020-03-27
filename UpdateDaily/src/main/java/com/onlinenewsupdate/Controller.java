package com.onlinenewsupdate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.onlinenewsupdate.service.DailyNewsUpdateService;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private DailyNewsUpdateService dailynewsService;

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView home(Model theModel, HttpServletRequest request) throws NullPointerException {

		System.out.println("home controller called");
		theModel.addAttribute("title", "DashBoard");

		theModel.addAttribute("userClickedlogin", false);
		theModel.addAttribute("userClicked", "BelalSoft");

		return new ModelAndView("index");
	}

	@PostMapping("/login")
	public String login(HttpServletRequest request, Model model) {

		model.addAttribute("title", "DashBoard");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email.isEmpty() || password.isEmpty()) {
			model.addAttribute("userClickedlogin", false);

			model.addAttribute("userClickedloginmsg", "sorry you have not enterd your email and password..");
		} 
		
		else {
			
			boolean result=dailynewsService.getLogin(email,password);
			if(result ==  true)
			{
				model.addAttribute("userClickedlogin", true);
				System.out.println("user enter" + email);	
			}
			else
			{
				model.addAttribute("userClickedlogin", false);

				model.addAttribute("userClickedloginmsg", "sorry you have not enterd your email and password..");
				
			}
			
			
			

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

}
