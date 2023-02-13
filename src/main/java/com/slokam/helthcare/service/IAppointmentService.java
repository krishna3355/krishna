package com.slokam.helthcare.service;

import com.slokam.helthcare.entity.Appointment;
import com.slokam.helthcare.exception.PatientException;

public interface IAppointmentService {
	public abstract void createAppointment(Appointment appointment) throws PatientException;
}
