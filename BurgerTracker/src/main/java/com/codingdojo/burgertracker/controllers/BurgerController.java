package com.codingdojo.burgertracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.burgertracker.models.Burger;
import com.codingdojo.burgertracker.services.BurgerServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/burger")
public class BurgerController {

	private final BurgerServices burgerServ;
	
	public BurgerController(BurgerServices burgerServ) {
		this.burgerServ = burgerServ;
		
	}
	
	//renders the form.
	
	@GetMapping("/new")
	public String newBurger(@ModelAttribute("burger") Burger burger) {
		return "index.jsp";
	}
	
	//show all, get all.
	@GetMapping("/all")
	public String showAll(Model model) {
		model.addAttribute("allburgers", burgerServ.getAll());
		return "showAll.jsp";
	}
	
	//show one/ get one.
	@GetMapping ("/show/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneBurger", burgerServ.getOne(id));
		return "showOne.jsp";
	}
	
	
	
	//create 
	//old way of doing this for post without form:form!
	
//	@PostMapping("/process/new")
//	public String createOne(@RequestParam("burgername") String burgername, @RequestParam("restaurantname") String restaurantname,
//			@RequestParam("rating") Integer rating, @RequestParam("notes") String notes) {
//		Burger newBurger = new Burger(burgername, restaurantname, rating, notes);
//		burgerServ.create(newBurger);
//		return "redirect:/burger/all";
//	}
	@PostMapping("process/new")
	public String createBurger(@Valid @ModelAttribute("burger") Burger newBurger, BindingResult result) {
		if(result.hasErrors()) {
			return"index.jsp";
		}
	
	burgerServ.create(newBurger);
	return "redirect:/burger/all";
	
	}
	
	//edit , first you grab by using GetMapping then Patch it
	
	@GetMapping("/edit/{id}")
	public String editBurger(@PathVariable ("id") Long id, Model model) {
		
		model.addAttribute("burger", burgerServ.getOne(id));
		return"edit.jsp";
	}
	@PatchMapping("/process/edit/{id}")
	public String processEditBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if(result.hasErrors()) {
			return"edit.jsp";
		}
		burgerServ.edit(burger);
		return"redirect:/burger/all";
	}
	
	
}
