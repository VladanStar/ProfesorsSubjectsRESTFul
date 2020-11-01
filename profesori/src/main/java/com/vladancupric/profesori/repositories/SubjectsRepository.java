package com.vladancupric.profesori.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vladancupric.profesori.entities.Profesor;
import com.vladancupric.profesori.entities.Subject;

public interface SubjectsRepository extends CrudRepository<Subject, Integer>{

	Subject findByCode (String code);
	//Subject findSubjectIgnoreCase(String code);
	
	List<Subject> findAllSubjectsByProfesors(Profesor profesor);
}
