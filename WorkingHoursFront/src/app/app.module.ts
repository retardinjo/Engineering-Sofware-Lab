import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import {FlexLayoutModule} from '@angular/flex-layout';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { LoginComponent } from './login/login.component';
import { BannerComponent } from './banner/banner.component';
import { FooterComponent } from './footer/footer.component';
import { CheckinComponent } from './checkin/checkin.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminUsersComponent } from './admin-users/admin-users.component';
import { AdminComponent } from './admin/admin.component';
import { AdminUserListComponent } from './admin-user-list/admin-user-list.component';
import { UserService } from './user.service';
import {HttpClientModule} from '@angular/common/http';
import { TestComponent } from './test/test.component';
import { AdminUpdateUserComponent } from './admin-update-user/admin-update-user.component';
import { ErrorComponent } from './error/error.component';
import { AdminTableComponent } from './admin-table/admin-table.component';
import { AdminOvertimeBonusComponent } from './admin-overtime-bonus/admin-overtime-bonus.component';
import { AdminOvertimeHoursComponent } from './admin-overtime-hours/admin-overtime-hours.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BannerComponent,
    FooterComponent,
    CheckinComponent,
    ProfileComponent,
    AdminUsersComponent,
    AdminComponent,
    AdminUserListComponent,
    TestComponent,
    AdminUpdateUserComponent,
    ErrorComponent,
    AdminTableComponent,
    AdminOvertimeBonusComponent,
    AdminOvertimeHoursComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule
    
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
