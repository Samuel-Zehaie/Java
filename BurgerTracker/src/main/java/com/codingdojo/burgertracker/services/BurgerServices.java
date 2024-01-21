package com.codingdojo.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.burgertracker.models.Burger;
import com.codingdojo.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerServices {
	
	private final BurgerRepository burgerRepo;

	public BurgerServices(BurgerRepository burgerRepo) {
		this.burgerRepo = burgerRepo;
		
	}
	public List<Burger> getAll() {
		return burgerRepo.findAll();
	}
	
	public Burger create(Burger burger) {
		return burgerRepo.save(burger);
	}
	public Burger getOne(Long id) {
		Optional<Burger> optionalBurger = burgerRepo.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		}else {
			return null;
		}
	}
	
	public Burger edit(Burger burger) {
		return burgerRepo.save(burger);
	}
	
	public void delete (Long id) {
		burgerRepo.deleteById(id);
	}
}
