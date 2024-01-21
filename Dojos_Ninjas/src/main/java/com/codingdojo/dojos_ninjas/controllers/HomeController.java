package com.codingdojo.dojos_ninjas.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojos_ninjas.models.Dojos;
import com.codingdojo.dojos_ninjas.models.Ninjas;
import com.codingdojo.dojos_ninjas.services.DojoService;
import com.codingdojo.dojos_ninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/home")
public class HomeController {

	private final DojoService dojoServ;
	
	private final NinjaService ninjaServ;
	
	public HomeController(DojoService dojoServ,NinjaService ninjaServ ) {
		this.dojoServ = dojoServ;
		this.ninjaServ = ninjaServ;
	}
	@GetMapping("")
	public String index() {
		return "Main/Dashboard.jsp";
	}
	@GetMapping("/dojo/new")
	public String createDojo(@ModelAttribute("dojo") Dojos dojo) {
		return "Dojo/Dojo.jsp";
	}
	
	@GetMapping("/ninja/new")
	public String createNinja(@ModelAttribute("ninja") Ninjas ninja, Model model) {
		model.addAttribute("allDojos", dojoServ.getAll());
		return "Ninja/Ninja.jsp";
	}
	
	@PostMapping("/dojo/process/create")
	public String processCreateDojo(@Valid @ModelAttribute ("dojo") Dojos dojo, BindingResult result) {
		if(result.hasErrors()) {
			return"Dojo/Dojo.jsp";	
	}
		dojoServ.create(dojo);
		return "redirect:/home";
}
	@PostMapping("/ninja/process/create")
	public String processCreateNinja(@Valid @ModelAttribute ("ninja") Ninjas ninja, BindingResult result) {
		if(result.hasErrors()) {
			return"Ninja/Ninja.jsp";
		}
		ninjaServ.create(ninja);
		return "redirect:/home";
	}
	
	@GetMapping("/ninja/all")
	public String showAllNinjas(Model model) {
		model.addAttribute("allNinjas", ninjaServ.getAll());
		return "Ninja/showAllNinja.jsp";
	}
	
	@GetMapping("/dojo/all")
	public String showAllDojos(Model model) {
		model.addAttribute("allDojos", dojoServ.getAll());
		model.addAttribute("allNinjas", ninjaServ.getAll());
		return "Dojo/showAllDojo.jsp";
	}
	@GetMapping("/dojo/display/{id}")
	public String oneDojo(Model model, @PathVariable("id") Long id) {
		model.addAttribute("dojo", dojoServ.getOne(id));
		return"Dojo/showOne.jsp";
	}
}
