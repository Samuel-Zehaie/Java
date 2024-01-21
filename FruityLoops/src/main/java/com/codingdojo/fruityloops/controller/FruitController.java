package com.codingdojo.fruityloops.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.fruityloops.Fruity;

@Controller
public class FruitController {
	
	@RequestMapping("/")
	public String First(Model model) {
		ArrayList<Fruity> fruits = new ArrayList<Fruity>();
		
		fruits.add(new Fruity("kiwi", 1.5));
		fruits.add(new Fruity("Mango", 2.0));
		fruits.add(new Fruity("Goji Berries", 4.0));
		fruits.add(new Fruity("Guava", .75));
		
		model.addAttribute("fruitsFromMyController", fruits);		
		return "index.jsp";
		
	}
}
