package com.slokam.helthcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.helthcare.entity.Visiting;

@Repository
public interface VisitingDAO extends JpaRepository<Visiting, Integer> {

	
}
