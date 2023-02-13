/*package com.slokam.da.hc.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.slokam.da.hc.entity.Patient;

public class PatientDataImport {

	public static Map<Integer,Integer> getPatientMap(List<Patient> patentList){
		Map<Integer, Integer> patientMap = new HashMap<>();
		int exId=1;
		for (Patient patient : patentList) {
			  patientMap.put( exId , patient.getId());
			  exId++;
		}
		return patientMap;
	}
	
	
	public static List<Patient> getPatientList(String filePath, String sheetName){
		List<Patient> patients = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			int number = sheet.getLastRowNum();
			for(int i=0;i<=number;i++){
				 HSSFRow row =  sheet.getRow(i);
				 String name = row.getCell(1).getStringCellValue();
				 Date date = row.getCell(2).getDateCellValue();
				 Long phone = (long) row.getCell(3).getNumericCellValue();
				 Patient p = new Patient();
				 p.setName(name);
				 p.setDob(date);
				 p.setPhone(phone);
				 patients.add(p);
			}
			fis.close();
			workbook.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return patients;
	}
}
*/