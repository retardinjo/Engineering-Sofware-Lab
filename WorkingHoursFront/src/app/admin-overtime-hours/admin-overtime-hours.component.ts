import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort, MatPaginator, MatTableDataSource } from '@angular/material';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-admin-overtime-hours',
  templateUrl: './admin-overtime-hours.component.html',
  styleUrls: ['./admin-overtime-hours.component.css']
})
export class AdminOvertimeHoursComponent implements OnInit {


  displayedColumns1 = ["fullName", "date", "overTimeWork"];
  searchKey : String;
  hoursSource:any;


  @ViewChild(MatSort) sort : MatSort;
  @ViewChild(MatPaginator) paginator : MatPaginator;

  constructor(private http : HttpClient, private service: UserService) { }

  ngOnInit() {

    this.service.getOverwork1().subscribe(
    	result=>{
    	if(!result){
    		return;
    	}
    	this.hoursSource = new MatTableDataSource(result as any);
    	 this.hoursSource.sort = this.sort;
   		 this.hoursSource.paginator = this.paginator;
    	}
    	
    	
    );

  }

  onSearchClear() {
    this.searchKey = ""; 
    this.doFilter();
  }

  doFilter() {
    this.hoursSource.filter = this.searchKey.trim().toLowerCase();
  }

}
