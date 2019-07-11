import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';
import { error } from 'util';

@Component({
  selector: 'app-checkin',
  templateUrl: './checkin.component.html',
  styleUrls: ['./checkin.component.css']
})
export class CheckinComponent implements OnInit {
user;
check;
  constructor(private http : HttpClient, private service : UserService) { }

  ngOnInit() {
    this.service.getUserByUsername().subscribe(
      result=>{
        console.log(result['userId']);
        this.user = result['userId'];
        this.check=result['checked'];
      }
    )
  }

  onSubmit(form : NgForm) {
    console.log(form.value.check_in_time);
    this.http.post("http://localhost:8032/workinghour/checkinbycard", form.value.check_in_time ,{withCredentials: true}).subscribe((data) => {alert('Checked in successfuly'),window.location.reload()});
  }

  onUpdate(form : NgForm) {
    console.log(form.value.check_out_time);
    this.http.put("http://localhost:8032/workinghour/checkout", form.value.check_out_time ,{withCredentials: true}).subscribe((data) => {alert('Checked out successfuly'),window.location.reload()}, error=>{alert('Error occurred')});
  }

}
