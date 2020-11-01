package com.vladancupric.profesori.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "subjects")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subject_id;
	
	private String name;
	private String code;
	private int ESPB;
	
	@ManyToMany(mappedBy = "subjects")
	private Set<Profesor> profesors;
	public Subject(int subject_id, String name, String code, int eSPB) {
		super();
		this.subject_id = subject_id;
		this.name = name;
		this.code = code;
		ESPB = eSPB;
	}
	public Subject() {
		super();
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getESPB() {
		return ESPB;
	}
	public void setESPB(int eSPB) {
		ESPB = eSPB;
	}
	@Override
	public String toString() {
		return "Subject [subject_id=" + subject_id + ", name=" + name + ", code=" + code + ", ESPB=" + ESPB + "]";
	}
	
	

}
