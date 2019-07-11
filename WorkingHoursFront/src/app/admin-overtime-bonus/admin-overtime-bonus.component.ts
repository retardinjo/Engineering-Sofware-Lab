import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../user.service';

@Component({
  selector: 'app-admin-overtime-bonus',
  templateUrl: './admin-overtime-bonus.component.html',
  styleUrls: ['./admin-overtime-bonus.component.css']
})
export class AdminOvertimeBonusComponent implements OnInit {

  displayedColumns2 = ['userFullName',  'month', 'bonus'];
  searchKey : String;
  bonusSource:any;


  @ViewChild(MatSort) sort : MatSort;
  @ViewChild(MatPaginator) paginator : MatPaginator;

  constructor(private http : HttpClient, private service: UserService) { }

  ngOnInit() {

    this.service.getOverworkBonus().subscribe(
    	result=>{
    	if(!result){
    		return;
    	}
    	console.log(result);
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
    this.bonusSource.filter = this.searchKey.trim().toLowerCase();
  }

}
