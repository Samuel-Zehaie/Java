package com.codingdojo.hoppersreceipt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homecontroller {
	
	@RequestMapping("/")
	public String index(Model model) {
		String name= "Samuel Zehaie";
		String itemName = "Iphone 15";
		double price = 600;
		String description = "Best cellphone, 15th times in a row!";
		String vendor= "NextCellection";
		
		model.addAttribute("name", name);
		model.addAttribute("item", itemName);
		model.addAttribute("price", price);
		model.addAttribute("description", description);
		model.addAttribute("vendor", vendor);
		
		return"index.jsp";
		
		
	}
}
