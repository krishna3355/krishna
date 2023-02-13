package com.slokam.helthcare.service;

import com.slokam.helthcare.entity.Doctor;
import com.slokam.helthcare.exception.PatientException;

public interface IDoctorService {
	public void save(Doctor doctor) throws PatientException;
}
