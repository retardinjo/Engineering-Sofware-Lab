import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'WorkingHoursFront';
user;
role;
  constructor(private http : HttpClient, private service : UserService) { }

  ngOnInit() {
    this.service.getUserByUsername().subscribe(
      result=>{
        console.log(result['userId']);
        this.role = result['role']['roleName'];
        this.user = result['userId'];

        
      }
    )

    
  }
}
