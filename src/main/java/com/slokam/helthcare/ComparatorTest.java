package com.slokam.helthcare;

import java.io.Serializable;
import java.util.Comparator;

import com.slokam.helthcare.entity.Patient;


public class ComparatorTest implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		Patient p1 = (Patient)o1;
		Patient p2 =(Patient)o2;
		return p1.getDob().compareTo(p2.getDob());
	}
}

class ComparatorTest2 implements Comparator<Patient>{
	@Override
	public int compare(Patient o1, Patient o2) {
		return o1.getDob().compareTo(o2.getDob());
	}
	
}
class sertest implements Serializable{
	
}