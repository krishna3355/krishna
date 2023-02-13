package com.slokam.helthcare;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HelthcareApplicationTests {
    
	@LocalServerPort
	private int port;
    //change from eclipse
    // change from bit bucket 
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void test1(){
    	
		/*ResponseEntity<Object> data = restTemplate.getForEntity("http://localhost:"+port+"/patient/doctors/kittu",Object.class);
		System.out.println(data);*/
		ResponseEntity<ArrayList> re = restTemplate.getForEntity("http://localhost:"+port+"/patient/doctors/kittu", ArrayList.class);
		List<String> list = re.getBody();
	    for (String string : list) {
			System.out.println(string);
		}
	    Assert.assertEquals(4, list.size());
	}
	
	/*@Mock
	private PatientDAO patientDAO;
	
	@InjectMocks
	private PatientServiceImpl patientService;
	
	
	@Test
	public void firstTest() {
		try {
			 Patient  patient1 =  new Patient(1,"Name",new Date(),345353L);
			 Optional<Patient> patientOption =
					Optional.of(patient1);
			 Mockito.when(patientDAO.findById(1)).thenReturn(patientOption);
			 Patient p =  patientService.getPatientById(1);
			 System.out.println(p);
		} catch (PatientException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestMaxAgePatientDetails(){
		List<Patient> patients =
						new ArrayList<>();
		 Patient  patient1 =  new Patient(1,"Name1",new Date(1982,12,12),1345353L);
		 Patient  patient2 =  new Patient(2,"Name2",new Date(1992,12,12),2345353L);
		 Patient  patient3 =  new Patient(3,"Name3",new Date(2000,12,12),3345353L);
		 Patient  patient4 =  new Patient(4,"Name4",new Date(1976,12,12),4345353L);
		 patients.add(patient4);
		 patients.add(patient3);
		 patients.add(patient2);
		 patients.add(patient1);
		 
		Mockito.when(patientDAO.findAll()).thenReturn(patients);
		Patient patient = patientService.getMaxAgePatient();
		
		Assert.assertEquals(patient4, patient);
	
	}*/

	
	
}

