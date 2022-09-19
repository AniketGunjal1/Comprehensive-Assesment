package com.doctors.crud.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.doctors.crud.entity.Doctors;
import com.doctors.crud.repository.DoctorsRepository;
import com.doctors.crud.service.DoctorsService;

@RestController
public class DoctorsController {
	
	@Autowired
	private DoctorsService service;
	
	@PostMapping("/addDoctor")
	public Doctors addDoctor(@RequestBody Doctors doctor) {
		
		
		return service.saveDoctor(doctor);
		
	}
	
	@PostMapping("/addDoctors")
	public List <Doctors> addDoctors(@RequestBody List <Doctors> doctors) {
		
		
		return service.saveDoctors(doctors);
		
	}
	
	
	@GetMapping("/allDoctors")
	public List <Doctors> findAllDoctors(){
		
		
		return service.getDoctors();
		
		
		
		
	}
	
	@GetMapping("/{field}")
	public List <Doctors> getDoctorsWithSort(@PathVariable String field){
		List <Doctors> allDoctors = service.findDoctorsWithSorting(field);
		return allDoctors;
	}
	
	@GetMapping("/doctorsById/{id}")
	public Doctors getDoctors(@PathVariable int id ){
		
		return service.getDoctorById(id);
	}
	
	
	@GetMapping("/doctorsByName/{name}")
	public Doctors findDoctorsByName(@PathVariable String name) {
		return service.getDoctorByName(name);
		
	}
	
	
	
	@PutMapping("/update")
	public Doctors updateDoctors(@RequestBody Doctors doctor) {
		return service.updateDoctors(doctor);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDoctors(@PathVariable int id ) {
		return service.deleteDoctor(id);
	}
	

	
	
	

}
