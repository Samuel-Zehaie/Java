package com.codingdojo.dojos_ninjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojos_ninjas.models.Ninjas;

@Repository
public interface NinjaRepository extends CrudRepository<Ninjas, Long> {
	List<Ninjas> findAll();
}
