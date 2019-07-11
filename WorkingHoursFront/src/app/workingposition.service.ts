import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class WorkingpositionService {



  constructor( private http : HttpClient ) {}
  
  getPositions() {
  	return this.http.get('http://localhost:8032/position/findall', {withCredentials: true});
  }
}
