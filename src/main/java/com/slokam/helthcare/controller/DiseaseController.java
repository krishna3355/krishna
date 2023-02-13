package com.slokam.helthcare.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.helthcare.entity.Disease;
import com.slokam.helthcare.exception.PatientException;
import com.slokam.helthcare.service.DiseaseService;

@RestController
@RequestMapping("disease")
public class DiseaseController {
	private static Logger LOGGER = LoggerFactory.getLogger(DiseaseController.class);
	@Autowired
	private DiseaseService diseaseService;
	
	@PostMapping("save") 
	public ResponseEntity<String> save( @Valid @RequestBody Disease disease) throws PatientException{
		LOGGER.debug("Entered into save");
		ResponseEntity<String> re= null;
		if(disease!=null){
			LOGGER.debug("doctor data"+disease);
			diseaseService.addDisease(disease);
			re = new ResponseEntity<String>(HttpStatus.CREATED);
		}else{
			re = new ResponseEntity<String>("null Disease",HttpStatus.BAD_REQUEST);
		}
		LOGGER.debug("Exit from save");
		return re;
	}
	
}
