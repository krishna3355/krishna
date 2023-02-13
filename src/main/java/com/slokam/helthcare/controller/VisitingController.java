package com.slokam.helthcare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.helthcare.entity.Visiting;
import com.slokam.helthcare.exception.PatientException;
import com.slokam.helthcare.service.IVisitingService;

@RestController
@RequestMapping("visiting")
public class VisitingController {
	private static Logger LOGGER = LoggerFactory.getLogger(VisitingController.class);
	@Autowired
	private IVisitingService visitingService;
	
	@PostMapping() 
	public ResponseEntity<String> visit(@RequestBody Visiting visiting) throws PatientException{
		LOGGER.debug("Entered into visit");
		ResponseEntity<String> re= null;
		if(visiting!=null){
			LOGGER.debug("visiting data"+visiting);
			visitingService.visit(visiting);
			re = new ResponseEntity<String>(HttpStatus.CREATED);
		}else{
			re = new ResponseEntity<String>("null visiting",HttpStatus.BAD_REQUEST);
		}
		LOGGER.debug("Exit from visit");
		return re;
	}
	
}
