package com.slokam.helthcare.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.helthcare.dao.AppointmentDAO;
import com.slokam.helthcare.dao.IDoctorDAO;
import com.slokam.helthcare.dao.PatientDAO;
import com.slokam.helthcare.dao.VisitingDAO;
import com.slokam.helthcare.entity.Appointment;
import com.slokam.helthcare.entity.Doctor;
import com.slokam.helthcare.entity.Patient;
import com.slokam.helthcare.entity.Visiting;
import com.slokam.helthcare.exception.PatientException;
import com.slokam.helthcare.service.IDataImportService;
import com.slokam.helthcare.util.DataImport;
import com.slokam.helthcare.util.DataImportPojo;
@Service
public class DataImportServiceImpl implements IDataImportService{

	@Autowired
	private PatientDAO patientDao;
	@Autowired
	private AppointmentDAO appointmentDao;
	@Autowired
	private IDoctorDAO doctorDao;
	@Autowired
	private VisitingDAO visitingDao;
	
	
	public List<DataImportPojo> importDataPreparation() {
		List<DataImportPojo> dataImportList = new ArrayList<>();
		DataImportPojo<Patient> data1 = new DataImportPojo("Patient.java",Patient.class,patientDao );
		DataImportPojo<Doctor> data2 = new DataImportPojo("Doctor.java",Doctor.class,doctorDao);
		DataImportPojo<Appointment> data3 = new DataImportPojo("Appointment.java",Appointment.class,appointmentDao);
		DataImportPojo<Visiting> data4 = new DataImportPojo("Visting.java",Visiting.class,visitingDao);
		dataImportList.add(data1);
		dataImportList.add(data2);
		dataImportList.add(data3);
		dataImportList.add(data4);
		return dataImportList;
	}
		
	
	@Override
	public void importData(String filePath) throws PatientException {
		//	Each Logic can be devided into one responsibilities.
		// List<Appointment> list =  DataImport.getList(filePath,sheetName,Appointment.class)
		Map<Class, Map<Integer,Integer>> map = new HashMap<Class, Map<Integer,Integer>>();
		/*List<DataImportPojo> dataImportList = importDataPreparation();
		
		for (DataImportPojo dataImportPojo : dataImportList) {
			String sheetName = dataImportPojo.getSheetName();
			Class entityClass = dataImportPojo.getEntityClass();
			Object daoObject = dataImportPojo.getDaoObject();
		    
			List<Object> entityList = DataImport.getData(filePath, "Patient.java", Patient.class,map);
			Class daoClassObj  = daoObject.getClass();
			try {
				Method method = daoClassObj.getMethod("saveAll");
				method.invoke(daoObject, entityList);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			
		}*/
		// filePath , map
		// sheet name , Pojo Class object , Dao Class Object.
		
		/*Object obj = patientDao;
		Class daoClassObj  = obj.getClass();
				try {
					Method method = daoClassObj.getMethod("saveAll");
					method.invoke(obj, patientList);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}*/
		
		
		
		
		
	
		
		List<Patient> patientList = DataImport.getData(filePath, "Patient.java", Patient.class,map);
		List<Patient> patientListLatest = patientDao.saveAll(patientList);
		Map<Integer, Integer> patientMap = DataImport.getMap(patientListLatest, Patient.class);
		map.put(Patient.class, patientMap);
		
		List<Appointment> appoitmentList = DataImport.getData(filePath, "Appointment.java", Appointment.class, map);
		List<Appointment> latestAppoitmentList =appointmentDao.saveAll(appoitmentList);
		Map<Integer,Integer> appointmentMap = DataImport.getMap(latestAppoitmentList, Appointment.class);
		map.put(Appointment.class, appointmentMap);
		
		
		List<Doctor> doctorList = DataImport.getData(filePath, "Doctor.java", Doctor.class, map);
		List<Doctor> latestDoctorList = doctorDao.saveAll(doctorList);
		Map<Integer,Integer> doctorMap = DataImport.getMap(latestDoctorList, Doctor.class);
		map.put(Doctor.class, doctorMap);
		
		List<Visiting> visitingList = DataImport.getData(filePath, "Visiting.java", Visiting.class, map);
		List<Visiting> latestVisitingList = visitingDao.saveAll(visitingList);
		Map<Integer,Integer> vistingMap =DataImport.getMap(latestVisitingList,Visiting.class);
		map.put(Visiting.class, vistingMap);
		
		
		/*//	 Patient
		List<Patient> patientList = PatientDataImport.getPatientList(filePath, "Patient.java");
		
		List<Patient> latestPatentList = patientDao.saveAll(patientList);
		Map<Integer, Integer> patientMap = PatientDataImport.getPatientMap(latestPatentList);
		
		//Appointments
		List<Appointment> appointmentList = AppointmentDataImport.getAppointments(filePath, "Appointment.java", patientMap);
		List<Appointment> latestAppointments = appointmentDao.saveAll(appointmentList);
		Map<Integer, Integer> appointmentMap = AppointmentDataImport.getAppointmentMap(latestAppointments);
		
		//DoctorDataImport
		List<Doctor> doctorList = DoctorDataImport.getDoctorData(filePath, "Doctor.java");
		List<Doctor> latestDoctorList= doctorDao.saveAll(doctorList);
		Map<Integer,Integer> doctorMap = DoctorDataImport.getDoctorMap(latestDoctorList);
		
		//Visting
		List<Visiting> visitingList = VisitingDataImport.getVistings(filePath, "Visiting.java", appointmentMap, doctorMap);
		visitingDao.saveAll(visitingList);*/

		
	}
	
	
}
