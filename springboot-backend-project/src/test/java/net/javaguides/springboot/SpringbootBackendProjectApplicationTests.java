package net.javaguides.springboot;




import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.repository.PatientsRepository;

@SpringBootTest
class SpringbootBackendProjectApplicationTests {

	@Autowired
    PatientsRepository pRepo;
	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	
	public void testCreate() {
		Patient p1=new Patient();
		p1.setId(155L);
		p1.setName("RK");
		p1.setVisitedDoctor("Dr.Shubham");
		p1.setDateofVisit("10-june-2021");
		pRepo.save(p1);
		assertNotNull(pRepo.getById(155L));
		
		
	}

	@Test
       public void testReadAll() {
		
		List<Patient> list = pRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
		
	}
	
	@Test
	public void UpdateTest() {
		
		Patient p1= new Patient();
		p1=pRepo.findById(156L).get();
		p1.setName("Virat Kohali");
		pRepo.save(p1);
		assertNotEquals("RK",pRepo.findById(156L).get().getName());
	}
	
	@Test
	public void deleteTest() {
    
	    pRepo.deleteById(157L);
	    assertThat(pRepo.existsById(157L)).isFalse();
	    
	}
	
	
}
