import { Component, OnInit } from '@angular/core';
import { WorkingpositionService } from '../workingposition.service';
import { RolesService } from '../roles.service';
import {NgForm} from '@angular/forms';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {
  trigger,
  state,
  style,
  animate,
  transition
} from '@angular/animations';

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin-users.component.html',
	styleUrls: ['./admin-users.component.css'],
	animations: [
		trigger('popOverState', [
			state('show', style({
				visibility: 'visible'
			})),
			state('hide', style({
				visibility: 'hidden'
			})),
			transition('show => hide', animate('600ms ease-out')),
			transition('hide => show', animate('600ms ease-in'))
		])
	]
})
export class AdminUsersComponent implements OnInit {
roles;
positions;
sesija;
show = false;

	get stateName() {
		return this.show ? 'show' : 'hide';
	}
	toggle() {
		this.show = !this.show;
	}

  constructor(private service: RolesService, private servicePosition: WorkingpositionService, private http : HttpClient) { }

  ngOnInit() {
	
		this.returnKey();
  
  	this.service.getRoles().subscribe(
	  		response=>{
	  		this.roles = response;
			}
  	)
  	
  	this.servicePosition.getPositions().subscribe(
  		response=>{
  			this.positions = response;
  		}
  	)
	  
	
  
		}
		
		returnKey() {
  		return this.http.get("http://localhost:8032/user/test", {withCredentials: true}).pipe(map(res => console.log("cookie: " + res)));
}
  
  
  onSubmit(form : NgForm) {
	
  	this.http.post("http://localhost:8032/user/save/", form.value, {withCredentials: true}).subscribe((data) => {alert("User created!"), window.location.reload();}, error=>alert("Error occured"));
}
}
