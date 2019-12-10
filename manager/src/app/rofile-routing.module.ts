import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RoleSearchComponent } from './view/role/search/role-search.component';
import { RoleFormComponent } from './view/role/form/role-form.component';
import { UserFormComponent } from './view/user/form/user-form.component';
import { UserSearchComponent } from './view/user/search/user-search.component';
import { CommonModule } from '@angular/common';


const routes: Routes = [
  { path: 'roles', component: RoleSearchComponent },
  { path: 'addrole', component: RoleFormComponent },
  { path: 'users', component: UserSearchComponent },
  { path: 'adduser', component: UserFormComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class RofileRoutingModule { }
