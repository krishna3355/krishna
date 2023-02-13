package com.slokam.helthcare.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.scope.DefaultScopedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.helthcare.entity.Patient;
import com.slokam.helthcare.exception.PatientException;
import com.slokam.helthcare.service.IPatientService;

@RestController
@RequestMapping("patient")
public class PatientController {
	private static Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
	@Autowired
	private IPatientService patientService;
	@PostMapping("savePatient")
	public void savePatient(@RequestBody Patient patient) throws PatientException{
		LOGGER.debug("Entered into savePatient");
		patient.setDob(new Date());
		patientService.savePatient(patient);
		LOGGER.debug("Exit from  savePatient");
	}
	
	 @GetMapping("/doctors/{pname}")
	 public ResponseEntity<List<String>> getDoctorNamesByPatientName(@PathVariable(name="pname") String name) throws PatientException{
		    LOGGER.debug("Entered into getDoctorNamesByPatientName");
			List<String> doctorNames = patientService.getDoctorNamesByPatientName(name); 
			ResponseEntity<List<String>> re =
					new ResponseEntity<List<String>>(doctorNames,HttpStatus.OK );
			LOGGER.debug("Exit from  getDoctorNamesByPatientName");
			return re;
	 }
	 @GetMapping("/all/{sortBy}")
	 public ResponseEntity<List<Patient>> getAllPatients(@PathVariable String sortBy) throws PatientException {
		  LOGGER.debug("Entered into List<Patient>");
		  List<Patient>  list = patientService.getAllPatients(sortBy);
		  ResponseEntity<List<Patient>> re =
					new ResponseEntity<List<Patient>>(list,HttpStatus.OK );
			LOGGER.debug("Exit from  List<Patient>");
			return re;
	 }
}
