import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../user.service';
@Component({
  selector: 'app-admin-table',
  templateUrl: './admin-table.component.html',
  styleUrls: ['./admin-table.component.css']
})
export class AdminTableComponent implements OnInit {

  displayedColumns1 = ["fullName", "date", "overTimeWork"];
  displayedColumns2 = ['userFullName', 'bonus', 'month'];
  searchKey : String;
  hoursSource:any;
  bonusSource:any;

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

    this.service.getOverworkBonus().subscribe(
    	result=>{
    	if(!result){
    		return;
    	}
    	this.bonusSource = new MatTableDataSource(result as any);
    	 this.bonusSource.sort = this.sort;
   		 this.bonusSource.paginator = this.paginator;
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
