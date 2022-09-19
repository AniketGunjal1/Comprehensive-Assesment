package com.doctors.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctors.crud.entity.Doctors;


@Repository
public interface  DoctorsRepository extends JpaRepository<Doctors, Integer> {

	

	Doctors findBySalary(int salary);

	Doctors findByName(String name);

	Object findByName(boolean equals);

	

	

	

}
