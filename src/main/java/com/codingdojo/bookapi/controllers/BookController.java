package com.codingdojo.bookapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookapi.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	private final BookService bookServe;


	public BookController(BookService bookServe) {
		this.bookServe = bookServe;
	}
	
	
	@GetMapping("/all")
	public String showAll(Model model) {
		model.addAttribute("allbooks", bookServe.getAll());
		return "show.jsp";
	}
	@GetMapping("/show/{id}")
	public String showOne(@PathVariable("id") Long id, Model model){
		model.addAttribute("oneBook", bookServe.getOne(id));
		return "showone.jsp";
}
}
