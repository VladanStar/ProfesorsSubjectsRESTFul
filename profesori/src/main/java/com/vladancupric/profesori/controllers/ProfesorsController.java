package com.vladancupric.profesori.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vladancupric.profesori.entities.Profesor;
import com.vladancupric.profesori.entities.Subject;
import com.vladancupric.profesori.repositories.ProfesorsRepository;
@CrossOrigin
@RestController
public class ProfesorsController {
	
	@Autowired
	private ProfesorsRepository repository;
	
	@GetMapping("/profesors")
	public List<Profesor> getAllProfesors(){
		return (List<Profesor>)repository.findAll();
				
	}
	@GetMapping("/profesors/{id}")
	public Profesor getProfesor(@PathVariable int id) {
		return repository.findById(id).orElse(null);
	}
	
	@PostMapping("/profesors")
	public Profesor addProfesor(@RequestBody Profesor profesor) {
		return repository.save(profesor);
	}
	// brisanje jednog profesora
		@DeleteMapping("/profesors/{id}")
		public void  deleteProfesor(@PathVariable int id) {
		 repository.deleteById(id);
		}
		// azuriranje profesora
		@PutMapping("/profesors/{id}")
		public Profesor updateProfesor(@PathVariable int id, @RequestBody Profesor profesor) {
			return repository.save(profesor);
			
		}
		// brojanje ukupnog broja profesora
		@GetMapping("profesori/count")
		public long getNumberOfProfesors(){
			return repository.count();
		}
		
		// dohvatanje svih profesora koji drze neki predmet
		@GetMapping("/profesori/subjects")
		public List<Profesor> getProfesorsBySubject(@RequestBody Subject subject){
			return repository.findAllProfesorsBySubjects(subject);
		}
}
