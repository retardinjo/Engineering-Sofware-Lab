import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

users;
  constructor(private service: UserService) { }

  ngOnInit() {
   	this.service.getUsers().subscribe(
	  		response=>{
	  		this.users = response;
	  		console.log(response);
  		}
  	)
  }

}
