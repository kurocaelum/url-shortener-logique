package com.logique.urlshortener.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logique.urlshortener.model.User;
import com.logique.urlshortener.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/dashboard")
	public String dashboard(Model model) {
		User user = userService.getCurrentUser();
		model.addAttribute("user", user);
		
		return "dashboard";
	}

}
