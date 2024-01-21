package com.codingdojo.bookapi.repositories;

import java.awt.print.Book;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookapi.models.BooksApi;

@Repository
public interface BookRepository extends CrudRepository<BooksApi, Long> {
	List<BooksApi> findAll();
}
