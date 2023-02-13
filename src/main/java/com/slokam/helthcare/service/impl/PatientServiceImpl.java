package com.slokam.helthcare.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.helthcare.comp.PatientComparator;
import com.slokam.helthcare.dao.PatientDAO;
import com.slokam.helthcare.entity.Patient;
import com.slokam.helthcare.exception.PatientException;
import com.slokam.helthcare.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService{
   private static Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class); 
	@Autowired
	private PatientDAO PatientDAO;
	@Override
 	public void savePatient(Patient patient)throws PatientException {
		
		LOGGER.debug("savePatient start");
		try{
			PatientDAO.save(patient);
		}catch(Exception e){
			e.printStackTrace();
			throw new PatientException("DB Problem",e);
		}
		
		LOGGER.debug("savePatient end");
	}
	  
	@Override
	public Patient getPatientById(Integer id)throws PatientException {
		  LOGGER.debug("getPatientById start");
		   Patient p = null; 
		  try{
				Optional<Patient> optional = PatientDAO.findById(id);
				if(optional.isPresent()){
					p = optional.get();
				}
			}catch(Exception e){
				e.printStackTrace();
				throw new PatientException("DB Problem",e);
			}
		  LOGGER.debug("getPatientById end");
		return p;
	}
	
	@Override
    public List<String> getDoctorNamesByPatientName(String name) throws PatientException{
		 LOGGER.debug("getDoctorNamesByPatientName start");
		 List<String> doctorNames=null;
		try {
			doctorNames = PatientDAO.getDoctorNamesByPatientName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PatientException("Db issue",e);
		}
		 LOGGER.debug("getDoctorNamesByPatientName end");	
		 return doctorNames;
	}
	
	@Override
		public List<Patient> getAllPatients(String sortBy) throws PatientException {
		LOGGER.debug("getAllPatients start");
		 List<Patient> patientList = PatientDAO.findAll();

		 Comparator<Patient> comparator = PatientComparator.getPatientComparator(sortBy);
		 Collections.sort(patientList,comparator);
		 LOGGER.debug("getAllPatients end");	
		return patientList;
		}
	
	
	public Patient getMaxAgePatient(){
		 Patient p = null;
		 LOGGER.debug("getMaxAgePatient start");
		 List<Patient> patientList = PatientDAO.findAll();
		 for (Patient patient : patientList) {
			 if(p==null){
				 p = patient;
			 }else{
				 Date dob1  = patient.getDob();
				 Date dob2  = p.getDob();
				 if(dob1.after(dob2)){
					 p=patient;
				 }
			 }
			 
		 }
		 LOGGER.debug("getMaxAgePatient end");	
		 return p;
	}
}
