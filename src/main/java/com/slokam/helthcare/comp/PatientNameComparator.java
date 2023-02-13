package com.slokam.helthcare.comp;

import java.util.Comparator;

import com.slokam.helthcare.entity.Patient;

public class PatientNameComparator implements Comparator<Patient> {
@Override
public int compare(Patient o1, Patient o2) {
	return o1.getName().compareTo(o2.getName());
}
}
