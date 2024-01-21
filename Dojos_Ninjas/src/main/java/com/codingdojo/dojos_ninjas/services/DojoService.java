package com.codingdojo.dojos_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojos_ninjas.models.Dojos;
import com.codingdojo.dojos_ninjas.models.Ninjas;
import com.codingdojo.dojos_ninjas.repository.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
	this.dojoRepo = dojoRepo;
}
	public Dojos create(Dojos dojo) {
	return dojoRepo.save(dojo);

	}
	
	public Dojos getOne(Long id) {
		Optional<Dojos> optionaldojo = dojoRepo.findById(id);
				
			return	optionaldojo.isPresent() ? optionaldojo.get(): null;
	}
	
	public List<Dojos> getAll() {
	    return dojoRepo.findAll();
	    
}

} 
