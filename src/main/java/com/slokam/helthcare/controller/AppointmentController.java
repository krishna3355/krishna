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

import com.slokam.helthcare.entity.Appointment;
import com.slokam.helthcare.exception.PatientException;
import com.slokam.helthcare.service.IAppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
	private static Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);
	@Autowired
	private IAppointmentService appointmentService;
	
	@PostMapping()
	public ResponseEntity<String> createAppointment
	  (@RequestBody Appointment appointment) throws PatientException{
		LOGGER.debug("Entered into createAppointment");
		 ResponseEntity<String> re =null;
		if(appointment!=null){
			LOGGER.debug("Appointment::"+appointment);
			appointmentService.createAppointment(appointment);
		    re = new ResponseEntity<String>("Successfully inserted",HttpStatus.OK);
		}else{
			re = new ResponseEntity<String>("Data is not present",HttpStatus.BAD_REQUEST);
		}
			
		LOGGER.debug("Exit from createAppointment");
		return re;
	}
}
