import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RolesService {
  
  constructor( private http : HttpClient ) {}
  
  getRoles() {
  	return this.http.get('http://localhost:8032/role/findall', {withCredentials: true});
  }
}
