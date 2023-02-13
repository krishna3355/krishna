package com.slokam.helthcare.service;

import com.slokam.helthcare.entity.Disease;
import com.slokam.helthcare.exception.PatientException;

public interface DiseaseService {
	public abstract void addDisease(Disease disease) throws PatientException;
}
