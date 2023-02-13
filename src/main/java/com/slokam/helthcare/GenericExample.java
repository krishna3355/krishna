package com.slokam.helthcare;

import java.util.ArrayList;
import java.util.List;

import com.slokam.helthcare.entity.Doctor;

public class GenericExample {
  
	public static void main(String[] args) {
	    // List<String>
	    List<Doctor> l = test();
	    for(int i =0; i<l.size();i++){
	    	  Doctor obj = l.get(i);
	    	  // Doctor obj = (Doctor)l.get(i)
	    	  System.out.println(obj.getName());
	    }
	    
	}
	
	public static List<Doctor> test(){
		   Doctor d1 = new Doctor();
		   d1.setName("A");
		   d1.setSpeci("A1");
		   Doctor d2 = new Doctor();
		   d2.setName("A");
		   d2.setSpeci("A1");
		   Doctor d3 = new Doctor();
		   d3.setName("A");
		   d3.setSpeci("A1");
		   
		   List<Doctor> list  = new ArrayList<>();
		   
		   list.add(d1);
		   list.add(d2);
		   list.add(d3);
		   
		  
		   return list;
	}
}
