package com.doctors.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DoctorsData")
public class Doctors {
	
	
	@Id
	private int id;
	private String name;
	private int salary;
	private String Specialist;
	
	
	public Doctors() {
		
		
	}


	public Doctors(int id, String name, int salary, String specialist) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		Specialist = specialist;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getSpecialist() {
		return Specialist;
	}


	public void setSpecialist(String specialist) {
		Specialist = specialist;
	}


		
	
	
	
	
	
	
	

}
