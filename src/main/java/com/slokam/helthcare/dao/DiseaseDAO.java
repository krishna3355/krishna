package com.slokam.helthcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.helthcare.entity.Disease;

@Repository
public interface DiseaseDAO extends JpaRepository<Disease, Integer> {
	public abstract Disease findByName(String name);
}

