package com.doctors.crud.custom.exception;

import java.util.NoSuchElementException;

import javax.persistence.EntityExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.doctors.crud.exception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice {
	
	

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		
		return new ResponseEntity<String>("Data Not Found.",HttpStatus.BAD_REQUEST);
		
		
	}


	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException){
			
		return new ResponseEntity<String>("No Value present in Database.",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<String> handleEntityExistsException(EntityExistsException entityExistException){
		
		return new ResponseEntity<String>("Same Data Already present in database.",HttpStatus.BAD_REQUEST);
	}
	
	
	
}
