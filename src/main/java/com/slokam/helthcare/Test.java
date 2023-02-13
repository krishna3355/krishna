package com.slokam.helthcare;

import java.lang.reflect.Field;

import com.slokam.helthcare.entity.Doctor;

public class Test {
	public static void main(String[] args) {
		test(Doctor.class);
	}

	public static void test(Class cls) {
		   /*Field[] fields =  cls.getDeclaredFields();
		   for (Field field : fields) {
			 System.out.println(field.getName());
			 System.out.println(field.getType());
			 System.out.println(field.getModifiers());
			 Annotation[] annotations = field.getDeclaredAnnotations();
			 for (Annotation annotation : annotations) {
				System.out.println(annotation.annotationType());
			 }
			 System.out.println("=================");
		   }*/
		   try {
			Object ob = cls.newInstance();
			Field declaredField = Doctor.class.getDeclaredField("name");
            boolean accessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            declaredField.set(ob, "SDFSDF");
            
            Doctor d = (Doctor)ob;
            System.out.println(d.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		   
	}
}
