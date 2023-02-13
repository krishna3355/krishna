package com.slokam.helthcare.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.slokam.helthcare.entity.Doctor;

public class DoctorDataImport {
	public static Map<Integer, Integer> getDoctorMap(List<Doctor> doctorList){
		 Map<Integer, Integer> doctorMap = new HashMap<>();
		 int key=1;
		 for (Doctor doctor : doctorList) {
			 doctorMap.put(key, doctor.getId());
			 key++;
		 }
		 return doctorMap;
	}
	public static List<Doctor> getDoctorData(String filePath,String sheetName){
		List<Doctor> doctors = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			int number = sheet.getLastRowNum();
			for(int i=0;i<=number;i++){
				 HSSFRow row =  sheet.getRow(i);
				 String name = row.getCell(1).getStringCellValue();
				 String spec = row.getCell(2).getStringCellValue();
				 Doctor doctor = new Doctor();
				 doctor.setName(name);
				 doctor.setSpeci(spec);
				 doctors.add(doctor);
			}
			fis.close();
			workbook.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return doctors;
		
	}
}
