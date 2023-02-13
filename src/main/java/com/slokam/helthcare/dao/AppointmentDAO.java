package com.slokam.helthcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.helthcare.entity.Appointment;

@Repository
public interface AppointmentDAO extends JpaRepository<Appointment, Integer>{
  
	 
	 
}
