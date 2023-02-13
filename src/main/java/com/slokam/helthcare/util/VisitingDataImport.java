package com.slokam.helthcare.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.slokam.helthcare.entity.Appointment;
import com.slokam.helthcare.entity.Doctor;
import com.slokam.helthcare.entity.Visiting;

public class VisitingDataImport {

	public static List<Visiting> getVistings(String filePath,String sheetName,
			 Map<Integer,Integer> appointmentMap,
			 Map<Integer,Integer> doctorMap){
		List<Visiting> visitingList = new ArrayList<>(); 
		try {
			FileInputStream fis = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			int number = sheet.getLastRowNum();
			for(int i=0;i<=number;i++){
				 HSSFRow row =  sheet.getRow(i);
				 Date visitingDate = row.getCell(1).getDateCellValue();
				 int doctorid = (int)row.getCell(2).getNumericCellValue();
				 int appointid = (int)row.getCell(3).getNumericCellValue();
				 int doctorDbId = doctorMap.get(doctorid);
				 int appointmentDbId = appointmentMap.get(appointid);
				 Visiting visiting = new Visiting();
				 visiting.setTime(visitingDate);
				 Doctor doctor = new Doctor();
				 doctor.setId(doctorDbId);
				 Appointment appointment = new Appointment();
				 appointment.setId(appointmentDbId);
				 visiting.setDoctor(doctor);
				 visiting.setAppointment(appointment);
				 visitingList.add(visiting); 
			}
			fis.close();
			workbook.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return visitingList;
	}
}
