package com.slokam.helthcare.service;

import java.util.List;

import com.slokam.helthcare.entity.Patient;
import com.slokam.helthcare.exception.PatientException;

public interface IPatientService {

	 public List<Patient> getAllPatients(String sortBy) throws PatientException;
	 public void savePatient(Patient patient) throws PatientException;
	 public Patient getPatientById(Integer id) throws PatientException;
	 public abstract List<String> getDoctorNamesByPatientName(String name)throws PatientException;
}
