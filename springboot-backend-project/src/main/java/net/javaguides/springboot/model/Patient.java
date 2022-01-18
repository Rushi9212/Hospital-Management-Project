package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Visited_Doctor")
	private String visitedDoctor;
	
	@Column(name="Dateof_Visit")
	private String dateofVisit;
	
	public Patient() {
		
	}

	public Patient( String name, String visitedDoctor, String dateofVisit) {
		super();
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateofVisit = dateofVisit;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public String getDateofVisit() {
		return dateofVisit;
	}
	public void setDateofVisit(String dateofVisit) {
		this.dateofVisit = dateofVisit;
	}
	
}
