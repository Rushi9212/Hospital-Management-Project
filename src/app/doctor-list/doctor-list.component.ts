import { Component, OnInit } from '@angular/core';
import{Doctor} from '../doctor';
@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {

  doctors:Doctor[];
  constructor() { }

  ngOnInit(): void {


    this.doctors =[{
      "id":201,
      "name":"Dr.Rajesh Prasad",
      "age":45,
      "gender":"Male",
      "specialistfields":"Dentist"

      },
     {
      "id":301,
      "name":"Dr.Rutuja K",
      "age":30,
      "gender":"Female",
      "specialistfields":"Psychiatrist"

      },
     {
      "id":401,
      "name":"Dr.Shubham K",
      "age":55,
      "gender":"Male",
      "specialistfields":"Neurologist"

      },
      {
      "id":501,
      "name":"Dr.Satya P",
      "age":40,
      "gender":"Male",
      "specialistfields":"Surgeon"


  }]
}

}
