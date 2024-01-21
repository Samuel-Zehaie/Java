package com.codingdojo.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.savetravels.models.Travel;

public interface TravelRepositories extends CrudRepository<Travel, Long> {
	List<Travel> findAll();
}
