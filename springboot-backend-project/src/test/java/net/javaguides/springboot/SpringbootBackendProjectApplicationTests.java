package net.javaguides.springboot;




import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import net.javaguides.springboot.controller.PatientController;


import net.javaguides.springboot.model.Patient;

@SpringBootTest
class SpringbootBackendProjectApplicationTests {

	@Autowired
	PatientController pRepo;
	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	
	public void testCreate() {
		Patient p1=new Patient();
		p1.setId(130L);
		p1.setName("Satyapriya");
		p1.setVisitedDoctor("Dr.Ram Prasad");
		p1.setDateofVisit("15-Jan-2022");
		pRepo.createPatient(p1);
		assertNotNull(pRepo.getPatientById(130L));
		
		
	}

	@Test
       public void testReadAll() {
		
		List<Patient> list = pRepo.getAllPatients();
		assertThat(list).size().isGreaterThan(0);
		
	}
}
