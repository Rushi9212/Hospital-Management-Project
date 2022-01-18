import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Patient} from '../patient';
import { PatientService } from '../patient.service';
@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients: Patient[];
    constructor(private patientService: PatientService,
      private router: Router
      ) { }

  ngOnInit(): void {

  /*
    this.patients =[{
      "id":1,
      "name":"Rushikesh",
      "visitedDoctor":"Kulkarni badri",
      "dateofVisit":"11-jan-2021"

    },
    {
      "id":2,
      "name":"Vaibhav",
      "visitedDoctor":"Kulkarni badri",
      "dateofVisit":"11-feb-2021"
    }]; */

    this.getPatients();
    }

    private getPatients(){
      this.patientService.getPatientsList().subscribe(data =>{
        this.patients=data;
      });
    

  }
  patientDetails(id:number){
    this.router.navigate(['patient-details',id]);
  }
  updatePatient(id:number){

    this.router.navigate(['update-patient',id]);
 }
 
 deletePatient(id:number){
  this.patientService.deletePatient(id).subscribe(data =>{
    console.log(data);
    this.getPatients();
  })
  

 }

}
