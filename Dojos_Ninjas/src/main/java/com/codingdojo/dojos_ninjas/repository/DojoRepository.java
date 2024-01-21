package com.codingdojo.dojos_ninjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojos_ninjas.models.Dojos;

@Repository
public interface DojoRepository extends CrudRepository<Dojos, Long> {
	List<Dojos> findAll();
}
