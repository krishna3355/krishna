package com.slokam.helthcare.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.helthcare.dao.IDoctorDAO;
import com.slokam.helthcare.entity.Doctor;
import com.slokam.helthcare.exception.PatientException;
import com.slokam.helthcare.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService{
   private static Logger LOGGER = LoggerFactory.getLogger(DoctorServiceImpl.class); 
	@Autowired
	private IDoctorDAO doctorDAO;
	@Override
 	public void save(Doctor doctor)throws PatientException {
		
		LOGGER.debug("save start");
		try{
			doctorDAO.save(doctor);
		}catch(Exception e){
			e.printStackTrace();
			throw new PatientException("DB Problem",e);
		}
		
		LOGGER.debug("save end");
	}
	  
	
	
}
