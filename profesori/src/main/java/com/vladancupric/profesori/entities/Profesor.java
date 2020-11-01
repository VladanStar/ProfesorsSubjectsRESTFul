package com.vladancupric.profesori.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name= "profesori")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String name;
	private String lastname;
	private String email;
	private String fakultet;
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name="profesorssubjects", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "subject_id"))
	private Set<Subject> subjects;
	
	
	public Profesor() {
		super();
	}


	public Profesor(int user_id, String name, String lastname, String email, String fakultet) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.fakultet = fakultet;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFakultet() {
		return fakultet;
	}


	public void setFakultet(String fakultet) {
		this.fakultet = fakultet;
	}


	@Override
	public String toString() {
		return "Profesor [user_id=" + user_id + ", name=" + name + ", lastname=" + lastname + ", email=" + email
				+ ", fakultet=" + fakultet + "]";
	}
	
	
	
	
}
