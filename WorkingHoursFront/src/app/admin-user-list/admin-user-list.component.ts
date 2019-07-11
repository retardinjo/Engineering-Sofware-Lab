import { Component, OnInit, AfterViewInit, ViewChild,  ChangeDetectorRef } from '@angular/core';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import { User } from '../user.model';
import { WorkPosition } from '../workposition.model'
import {HttpClient} from '@angular/common/http';
import {NgForm} from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-admin-user-list',
  templateUrl: './admin-user-list.component.html',
  styleUrls: ['./admin-user-list.component.css']
})
export class AdminUserListComponent implements OnInit, AfterViewInit {

  displayedColumns = ["firstName","lastName","email","username","position", "actions"];
  userSource:any;
  searchKey: string;
  user;
  
  @ViewChild(MatSort) sort : MatSort;
  @ViewChild(MatPaginator) paginator : MatPaginator;

  constructor(private service : UserService, private http : HttpClient, private changeDetectorRefs: ChangeDetectorRef) { }

  ngOnInit() {
  	
    this.service.getUsers().subscribe(
    	result=>{
    	if(!result){
    		return;
    	}
    	
    	this.userSource = new MatTableDataSource(result as any);
    	 this.userSource.sort = this.sort;
   		 this.userSource.paginator = this.paginator;
   		 this.changeDetectorRefs.markForCheck();
    	}
    	
    	
    );
    
    
    
      }

  ngAfterViewInit() {

    
  }

  onSearchClear() {
    this.searchKey = ""; 
    this.doFilter();
  }

  doFilter() {
    this.userSource.filter = this.searchKey.trim().toLowerCase();
  }
  
  onDelete(form : NgForm) {
  	this.http.delete("http://localhost:8032/user/deletebyid/"+form.value.userId, {withCredentials: true}).subscribe((data) => {}, error=>{alert("User deleted"), window.location.reload();});
  	this.changeDetectorRefs.detectChanges();
  	this.paginator._changePageSize(this.paginator.pageSize);
  }

  

}
