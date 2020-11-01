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
import com.vladancupric.profesori.repositories.SubjectsRepository;
@CrossOrigin
@RestController
public class SubjectsController {
	
	@Autowired
	private SubjectsRepository repository;
	
	@GetMapping("/subjects")
	public List<Subject> getAllSubjects(){
		return (List<Subject>)repository.findAll();
	
	}
	// dohvatanje jednog predmeta
		@GetMapping("/predmet/{id}")
		public Subject getSubject(@PathVariable int id) {
			return repository.findById(id).orElse(null);

		}
		// kreiranje predmeta
		@PostMapping("/subjects")
		public Subject addSubject(@RequestBody Subject subject) {
		return repository.save(subject);
		}
		// brisanje jednog predmeta
		@DeleteMapping("/subjects/{id}")
		public void  deleteSubject(@PathVariable int id) {
		 repository.deleteById(id);
		}
		// azuriranje predmeta
		@PutMapping("/subjects/{id}")
		public Subject updateSubject(@PathVariable int id, @RequestBody Subject subject) {
			return repository.save(subject);
			
		}
		// broj predmeta u bazi
		@GetMapping("predmet/count")
		public long getNumberOfPredmets(){
			return repository.count();
		}
		// 
		@GetMapping("/subjects/search/{code}")
		public Subject getSubjectByCode(@PathVariable String code) {
			return repository.findByCode(code);
		}
		
		@GetMapping("/subjects/profesor")
		public List<Subject> getSubjectsByProfesor(@RequestBody Profesor profesor){
			return repository.findAllSubjectsByProfesors(profesor);
		}


}
