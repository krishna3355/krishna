package com.slokam.helthcare.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.slokam.helthcare.entity.Appointment;
import com.slokam.helthcare.entity.Patient;

public class AppointmentDataImport {

	public static Map<Integer,Integer> getAppointmentMap(List<Appointment> appList){
		Map<Integer, Integer> appointmentMap =	new HashMap<>();
		int id=1;
		for (Appointment appointment : appList) {
			appointmentMap.put(id, appointment.getId()) ;
			id++;
		}
		return appointmentMap;
	}
	public static List<Appointment> getAppointments(String filePath,
			String sheetName,
			Map<Integer, Integer> patientMap){
		
		List<Appointment> appointments = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			int number = sheet.getLastRowNum();
			for(int i=0;i<=number;i++){
				 HSSFRow row =  sheet.getRow(i);
				 Date taken = row.getCell(1).getDateCellValue();
				 Date reqestedDate = row.getCell(2).getDateCellValue();
				 String  comments = row.getCell(3).getStringCellValue();
				 Integer patRef = (int) row.getCell(4).getNumericCellValue();
				 int dbid = patientMap.get(patRef);
				 Patient parentRef = new Patient();
				 parentRef.setId(dbid);
				 Appointment appointment = new Appointment();
				 appointment.setComments(comments);
				 appointment.setTaken(taken);
				 appointment.setReqDate(reqestedDate);
				 appointment.setPatient(parentRef);
				 appointments.add(appointment);
				 
			}
			fis.close();
			workbook.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return appointments;
	}
}
