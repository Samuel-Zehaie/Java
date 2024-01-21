package com.codingdojo.savetravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.savetravels.models.Travel;
import com.codingdojo.savetravels.services.TravelServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/expenses")
public class TravelController {
	
	private final TravelServices travelServ;

	public TravelController(TravelServices travelServ) {
		this.travelServ= travelServ;
	}
	//renders the form, its also showing all travels.
	
	@GetMapping("")
	public String newTravel( @ModelAttribute("travel") Travel travel, Model model) {
		model.addAttribute("allTravel", travelServ.getAll());
		return "index.jsp";
	}

	//show all, get all.
//	@GetMapping("/all")
//	public String showAll(Model model) {
//		model.addAttribute("allTravel", travelServ.getAll());
//		return "index.jsp";
//	}
	
	//show one/ get one.
	@GetMapping ("/show/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		model.addAttribute("travel", travelServ.getOne(id));
		return "showone.jsp";
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
	@PostMapping("process/create")
	public String createTravel(@Valid @ModelAttribute("travel") Travel newTravel, BindingResult result) {
		if(result.hasErrors()) {
			return"index.jsp";
		}
	
	travelServ.create(newTravel);
	return "redirect:/expenses";
	
	}
	
	//edit , first you grab by using GetMapping then Patch it
	
	@GetMapping("/edit/{id}")
	public String editTravel(@PathVariable ("id") Long id, Model model) {
		
		model.addAttribute("travel", travelServ.getOne(id));
		return"edit.jsp";
	}
	@PatchMapping("/process/edit/{id}")
	public String processEditTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
		if(result.hasErrors()) {
			return"edit.jsp";
		}
		travelServ.edit(travel);
		return"redirect:/expenses";
	}
	@DeleteMapping("delete/{id}")
	public String deleteOne(@PathVariable("id") Long id) {
		travelServ.delete(id);
	return "redirect:/home";
	}
}

