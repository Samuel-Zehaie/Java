package com.codingdojo.bookapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.bookapi.models.BooksApi;
import com.codingdojo.bookapi.services.BookService;

@RestController
@RequestMapping("/api")
public class BookApiController {
	
	private final BookService bookServe;

	public BookApiController(BookService bookServe) {
		this.bookServe= bookServe;		
	}
	@GetMapping("/books")
	public List<BooksApi> findAllDonations(){
		return bookServe.getAll();
	}
	
	@PostMapping("/books")
	public BooksApi createBook(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("lang") String lang, @RequestParam("numofpages") Integer numofpages) {
		BooksApi newBook = new BooksApi(title,description,lang,numofpages);
		return bookServe.create(newBook);
		
	}
	
	@GetMapping("/books/{id}")
	public BooksApi oneBook(@PathVariable("id") Long id) {
		return bookServe.getOne(id);
	}
		
	
	@PatchMapping("/books/{id}")
	public BooksApi edit(@PathVariable("id") Long id,@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("lang") String lang, @RequestParam("numofpages") Integer numofpages) 
	{
		BooksApi possibleBook = bookServe.getOne(id);
		if(possibleBook == null) {
			return null;
		}
		BooksApi bookToEdit = new BooksApi(id,title, description, lang, numofpages);
		return bookServe.edit(bookToEdit);
	}

		
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable("id") Long id){
		bookServe.delete(id);
		return "you have deleted " + id + " id"; 
	}

	}
	
	