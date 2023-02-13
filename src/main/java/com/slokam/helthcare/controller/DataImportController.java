package com.slokam.helthcare.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.slokam.helthcare.exception.PatientException;
import com.slokam.helthcare.service.IDataImportService;

@RestController
@RequestMapping("dataImport")
public class DataImportController {

	@Autowired
	private IDataImportService dataImportService;
	
	@PostMapping
	public void importData(MultipartFile fileData) throws PatientException{
		System.out.println(fileData.getOriginalFilename());
		System.out.println(fileData.getSize());
		String fileName ="G:\\uploads\\f23\\"+fileData.getOriginalFilename();
		File file = new File(fileName);
		Map<Integer, Integer> patientMap= null;
		try {
			fileData.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataImportService.importData(fileName);
		
	/*	// Read excell data and save into patient.
		try {
			FileInputStream fis = new FileInputStream("G:\\data\\f23\\HospatalDBData.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheet("Patient.java");
			int number = sheet.getLastRowNum();
			List<Patient> patients = new ArrayList<>();
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
			List<Patient> finalList = patientDao.saveAll(patients);
			
			patientMap = new LinkedHashMap();
			int i=1;
			for (Patient patient2 : finalList) {
				patientMap.put(i, patient2.getId());
				i++;
			}
			
			// Appointment :
			
		
	}
		catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis2 = new FileInputStream("G:\\data\\f23\\HospatalDBData.xls");
			HSSFWorkbook workbook2 = new HSSFWorkbook(fis2);
			HSSFSheet sheet2 = workbook2.getSheet("Appointment.java");
			int number2 = sheet2.getLastRowNum();
			List<Appointment> appointments = new ArrayList<>();
			for(int j=0;j<=number2;j++){
				 HSSFRow row =  sheet2.getRow(j);
				 Date taken  = row.getCell(1).getDateCellValue();
				 Date requested = row.getCell(2).getDateCellValue();
				 String comments = row.getCell(3).getStringCellValue();
				 int pid = (int)row.getCell(4).getNumericCellValue();
				 
				 int opid = patientMap.get(pid);
				 
				 Patient refp = new Patient();
				 refp.setId(opid);
				 Appointment app = new Appointment();
				 app.setComments(comments);
				 app.setReqDate(requested);
				 app.setTaken(taken);
				 app.setPatient(refp);
				 appointments.add(app);
			}
		
			appointDao.saveAll(appointments);
			
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/

		
		
	}
	
}
