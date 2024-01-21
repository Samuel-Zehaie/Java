package com.codingdojo.loginreg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.loginreg.models.User;
import com.codingdojo.loginreg.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserService userServ;

	public HomeController() {
		
	}
	@GetMapping("")
	public String index(HttpSession session, Model model) {
		Long userId=(Long) session.getAttribute("user_id");
		if(session.getAttribute("user_id")== null) {
			return "redirect:/users/login/register";
		}
		User user= userServ.getUser(userId);
		if(user != null) 
		model.addAttribute("username", user.getUserName());
		return "main/dashboard.jsp";
	
	}

	
}

	