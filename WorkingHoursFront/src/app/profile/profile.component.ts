import { Component, OnInit, OnDestroy } from '@angular/core';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit, OnDestroy {
overwork;
private paramsSubscription : Subscription;
private bonusSubscription: Subscription;
user;
overworkBonus;
average;
hours;
wholeUser;
  constructor(private http : HttpClient, private userService: UserService, private route: ActivatedRoute) {
    this.route.params.subscribe(params => this.user= params.id)
   }

  ngOnInit() {

    this.userService.getUser(this.user).subscribe(
      response=>{
        this.wholeUser = response;
      }
    )
    
    this.paramsSubscription = this.userService.getOverwork1().subscribe(
        res=>{
          console.log(res);
          this.overwork = res;
        }
    );

    this.bonusSubscription = this.userService.getOverworkBonus().subscribe(
      res=>{
        console.log(res);
        this.overworkBonus = res;
      }

     
      )

      this.userService.getAverage(this.user).subscribe(
        result=>{
          console.log(result);
          this.average = result;
        }

       
  );

    this.userService.getHoursPerDay(this.user).subscribe(
      result=>{
        console.log(result);
        this.hours = result;
      }

  );
    


   

  }

  ngOnDestroy() {
    this.paramsSubscription.unsubscribe();
  }

}
