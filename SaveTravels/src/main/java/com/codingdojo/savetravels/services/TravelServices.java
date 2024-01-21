package com.codingdojo.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Travel;
import com.codingdojo.savetravels.repositories.TravelRepositories;

@Service
public class TravelServices {
	
	private final TravelRepositories travelRepo;

	public TravelServices(TravelRepositories travelRepo) {
		this.travelRepo = travelRepo;
	}
	
	public List<Travel> getAll(){
		return travelRepo.findAll();
	}
	
	public Travel create(Travel travel) {
		return travelRepo.save(travel);
	}
	
	public Travel getOne(Long id) {
		Optional<Travel> optionalTravel= travelRepo.findById(id);
		if(optionalTravel.isPresent()) {
			return optionalTravel.get();
		}else {
			return null;
		}
	}
	
	public Travel edit(Travel travel) {
		return travelRepo.save(travel);
	}
	public void delete(Long id) {
		travelRepo.deleteById(id);
	}
	
	
}
