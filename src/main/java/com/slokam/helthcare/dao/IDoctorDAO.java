package com.slokam.helthcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.helthcare.entity.Doctor;
@Repository
public interface IDoctorDAO  extends JpaRepository<Doctor, Integer>{

}
