package com.codingdojo.omikujiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class OmikujiController {
	@GetMapping("/display")
	public String displayForm() {
		return "form.jsp";
	}
	
	@PostMapping("/process")
	public String Process(@RequestParam ("number") int number, @RequestParam("city") String city, @RequestParam("person") String person, @RequestParam("hobby") String hobby, @RequestParam("living") String living
, @RequestParam("comment") String comment, HttpSession session, RedirectAttributes redirectAttributes, @RequestParam("name") String name) {
		if(number <5 || number > 25) {
			redirectAttributes.addFlashAttribute("error", "number needs to be between 5 and 25");
			return "redirect:/display";
		}	
		session.setAttribute("name", name);
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living",living);
		session.setAttribute("comment", comment);
	

	return "redirect:/show";
}
	@GetMapping("/show")
	public String Show() {
		return "render.jsp";
	}
	
}


