import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { ActivatedRoute } from '@angular/router';
import { WorkingpositionService } from '../workingposition.service';
import { RolesService } from '../roles.service';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
	selector: 'app-admin-update-user',
	templateUrl: './admin-update-user.component.html',
	styleUrls: ['./admin-update-user.component.css']
})
export class AdminUpdateUserComponent implements OnInit {

	user$: Object;
	roles;
	positions;

	constructor(private http: HttpClient, private roleService: RolesService, private servicePosition: WorkingpositionService, private service: UserService, private route: ActivatedRoute) {
		this.route.params.subscribe(params => this.user$ = params.id)
	}

	ngOnInit() {
		this.service.getUser(this.user$).subscribe(
			service => this.user$ = service
		)

		this.roleService.getRoles().subscribe(
			response => {
				this.roles = response;
			}
		)

		this.servicePosition.getPositions().subscribe(
			response => {
				this.positions = response;
			}
		)
	}

	onSubmit(form: NgForm) {
		this.http.put("http://localhost:8032/user/update/" + form.value.userId, form.value, { withCredentials: true }).subscribe((data) => { alert("User updated!")} , error=>alert("Error occured"));
	}

}
