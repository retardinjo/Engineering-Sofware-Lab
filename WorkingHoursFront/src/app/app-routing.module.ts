import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CheckinComponent } from './checkin/checkin.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminComponent } from './admin/admin.component';
import { AdminUsersComponent } from './admin-users/admin-users.component';
import { AdminUserListComponent } from './admin-user-list/admin-user-list.component';
import { TestComponent } from './test/test.component';
import { AdminUpdateUserComponent } from './admin-update-user/admin-update-user.component';
import { ErrorComponent } from './error/error.component';
import { AdminTableComponent } from './admin-table/admin-table.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'check-in', component: CheckinComponent},
  {path: 'profile/:id', component: ProfileComponent},
  {path: '', redirectTo: 'check-in', pathMatch: 'full'},
  {path: 'test', component: TestComponent},
  {path: 'admin',
  component: AdminComponent,
  children: [
    {path: 'users', component: AdminUsersComponent},
    {path: 'update-user/:id', component: AdminUpdateUserComponent},
    {path: 'user-list', component: AdminUserListComponent},
    {path: 'table', component: AdminTableComponent},
    {path: '**', redirectTo: 'error'}
  ]
},
{path: 'error', component: ErrorComponent},
{path: '**', redirectTo: 'error'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
