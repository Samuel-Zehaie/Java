package com.codingdojo.dojos_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojos_ninjas.models.Ninjas;
import com.codingdojo.dojos_ninjas.repository.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepo; 
	public NinjaService( NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}

	public Ninjas getOne(Long id){
	    Optional <Ninjas>ninja =ninjaRepo.findById(id);
	    return ninja.isPresent() ? ninja.get() : null;
	}

	public List<Ninjas> getAll() {
	    return(List<Ninjas>)ninjaRepo.findAll();
	}

	public Ninjas create(Ninjas ninja) {
	    return ninjaRepo.save(ninja);
	}

	public Ninjas update(Ninjas ninja) {
	    return ninjaRepo.save(ninja);
	}

	public void delete(Long id){
	   ninjaRepo.deleteById(id);
	}
}
