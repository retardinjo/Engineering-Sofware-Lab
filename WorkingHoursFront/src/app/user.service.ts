import { User } from './user.model';
import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class UserService {

 constructor( private http : HttpClient ) {}

  getUsers() {
      return this.http.get('http://localhost:8032/user/findall', {withCredentials: true});
  }
  
  getUser(userId){
  	return this.http.get('http://localhost:8032/user/findbyid/'+userId, {withCredentials: true});
  }

  getUserByUsername(){
  	return this.http.get('http://localhost:8032/user/findbyusername', {withCredentials: true});
  }

  getOverworkBonus() {
    return this.http.get('http://localhost:8032/user/overtimeworkbonus', {withCredentials: true});
  }

  getHoursPerDay(userId) {
    return this.http.get('http://localhost:8032/user/gethours/'+ userId, {withCredentials: true});
  }

  getOverwork1() {
  	return this.http.get('http://localhost:8032/user/overtimework', {withCredentials: true});
  }

  getAverage(userId) {
    return this.http.get('http://localhost:8032/user/getaverage/' + userId, {withCredentials: true});
  }

}

