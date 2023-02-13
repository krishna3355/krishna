package com.slokam.helthcare.service;

import com.slokam.helthcare.entity.Visiting;
import com.slokam.helthcare.exception.PatientException;

public interface IVisitingService {
	public void visit(Visiting visiting) throws PatientException;
}
