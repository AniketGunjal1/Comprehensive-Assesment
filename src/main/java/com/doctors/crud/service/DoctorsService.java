package com.doctors.crud.service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.doctors.crud.entity.Doctors;
import com.doctors.crud.exception.EmptyInputException;
import com.doctors.crud.repository.DoctorsRepository;


@Service
public class DoctorsService {
	@Autowired
	private DoctorsRepository repository;
	
	
	public Doctors saveDoctor(Doctors doctor) {
		
		
		//if(repository.findByName(doctor.equals(doctor)) == repository.findByName(true)) {
		//if(doctor.getName().isEmpty() || doctor.getName().length()==0) {
		if(doctor.equals(doctor)) {
			throw new EntityExistsException("Duplicate Data");
		}
		return repository.save(doctor);
		
	}
	
	public List <Doctors> saveDoctors(List<Doctors> doctors){
		//doctors = repository.findAll();
		if(doctors.equals(getDoctors())) {
			throw new EmptyInputException("602","Data is Already Present.");
		}
		return repository.saveAll(doctors);
		
	}
	
	public List<Doctors> getDoctors(){
		return repository.findAll();
		
	}
	
	public List<Doctors> findDoctorsWithSorting(String field){
		return repository.findAll(Sort.by(Sort.Direction.DESC,field));
	}
	
	public Doctors getDoctorById(int id) {
		
		if(repository.findById(id) == repository.findById(id)) {
			throw new EmptyInputException("604","No Such data Found ");
		}
		
		return repository.findById(id).orElse(null);
		
	}
	
	
	public Doctors getDoctorByName(String name) {
		return repository.findByName(name);
	}
	
	 public String deleteDoctor(int id) {
		 if(repository.findById(id) == repository.findById(id)) {
				throw new EmptyInputException("604","No Such data Found ");
			}
		 

		 repository.deleteById(id);
		 
    	 return "Doctor is  Removed !!!"+id;
    }
    
    public Doctors updateDoctors(Doctors doctor) {
    	Doctors existingDoctors = repository.findById(doctor.getId()).orElse(null);   	
    	existingDoctors.setName(doctor.getName());
    	existingDoctors.setSalary(doctor.getSalary());
    	existingDoctors.setSpecialist(doctor.getSpecialist());
    	return repository.save(existingDoctors);
    }

	

}
