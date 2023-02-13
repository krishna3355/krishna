package com.slokam.helthcare.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class PatientExceptionHandler {

	private Logger LOGGER = LoggerFactory.getLogger(PatientExceptionHandler.class);
	
	@ExceptionHandler(PatientException.class)
	public ResponseEntity<String> handlePatientException(PatientException pe){
		LOGGER.debug("entered into handlePatientException");
		ResponseEntity<String> re = new ResponseEntity(pe.getMessage()+"::"+pe.getCause(), HttpStatus.INTERNAL_SERVER_ERROR );
		LOGGER.debug("exit from handlePatientException");
		return re;
	}
	
}
