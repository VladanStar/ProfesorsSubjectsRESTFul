package com.vladancupric.profesori.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vladancupric.profesori.entities.Profesor;
import com.vladancupric.profesori.entities.Subject;

public interface ProfesorsRepository extends CrudRepository<Profesor, Integer>{
	
	List<Profesor> findAllProfesorsBySubjects(Subject subject);

}
