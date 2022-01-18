package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.repository.PatientsRepository;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/")

public class PatientController {
	
	@Autowired
	private PatientsRepository patientRepository;

	// get all patients
		@GetMapping("/patients")
		public List<Patient> getAllPatients(){
			return patientRepository.findAll();
		}

		// create patients rest api
		@PostMapping("/patients")
		public Patient createPatient(@RequestBody Patient patient) {
			return patientRepository.save(patient);
		}

		// get patients by id rest api
		@GetMapping("/patients/{id}")
		public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
			Patient patient = patientRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("patient not exist with id :" + id));
			return ResponseEntity.ok(patient);
		}
		
		@PutMapping("/patients/{id}")
		public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails){
			Patient patient = patientRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("patient not exist with id :" + id));
			
              patient.setName(patientDetails.getName());
              patient.setVisitedDoctor(patientDetails.getVisitedDoctor());
              patient.setDateofVisit(patientDetails.getDateofVisit());
			
			
			
			Patient updatePatient = patientRepository.save(patient);
			return ResponseEntity.ok(updatePatient);
		}

		
		// delete patients rest api
		@DeleteMapping("/patients/{id}")
		public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id){
			Patient patient = patientRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("patient not exist with id :" + id));
			
			patientRepository.delete(patient);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
}
