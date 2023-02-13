package com.slokam.helthcare.comp;

import java.util.Comparator;

import com.slokam.helthcare.entity.Patient;

public class PatientDobComparator implements Comparator<Patient>{

	  @Override
	public int compare(Patient o1, Patient o2) {
		// TODO Auto-generated method stub
		return o1.getDob().compareTo(o2.getDob());
	}
}
