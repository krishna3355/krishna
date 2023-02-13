package com.slokam.helthcare;

import com.slokam.helthcare.entity.Doctor;
import com.slokam.helthcare.entity.Patient;

public class ComparatorMain {
	public static void main(String[] args) {
		ComparatorTest comp1 = new ComparatorTest();
		Patient p1 = new Patient();
		Patient p2 = new Patient();
		Doctor  d1 = new Doctor();
		comp1.compare(p1, d1);
		ComparatorTest2 comp2 = new ComparatorTest2();
		
		A<Patient> a = new A();
		a.saveData(p1);

		A<Doctor> a2 = new A();
		a2.saveData(d1);
		
	}
}
class A<T>{
	void saveData(T t){
		System.out.println("Saving data::"+t);
	}
}


class ABC{
	
	public static <O> void saveData(O a){
		 System.out.println(a);
	}
	
}




