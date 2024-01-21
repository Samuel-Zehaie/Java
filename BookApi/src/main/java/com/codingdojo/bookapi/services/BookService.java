package com.codingdojo.bookapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.bookapi.models.BooksApi;
import com.codingdojo.bookapi.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public List<BooksApi> getAll() {
		return bookRepository.findAll();
	}
	public BooksApi create(BooksApi book) {
		return bookRepository.save(book);
	}
	public BooksApi getOne(Long id) {
		Optional<BooksApi> optionalBooksApi = bookRepository.findById(id);
		if(optionalBooksApi.isPresent()) {
			return optionalBooksApi.get();
		}else {
			return null;
		}
//		return optionalBooksApi.isPresent() ? optionalBooksApi.get(); null;
	}
	public BooksApi edit(BooksApi book) {
		return bookRepository.save(book);
	}
	
	public void delete (Long id) {
		bookRepository.deleteById(id);
}
}
