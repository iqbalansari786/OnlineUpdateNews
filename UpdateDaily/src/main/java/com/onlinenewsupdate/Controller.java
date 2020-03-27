package com.onlinenewsupdate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

}
