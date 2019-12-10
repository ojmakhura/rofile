import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { RofileRoutingModule } from './rofile-routing.module';
import { RofileComponent } from './rofile.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RoleSearchComponent } from './view/role/search/role-search.component';
import { RoleFormComponent } from './view/role/form/role-form.component';
import { RoleService } from './service/role/role.service';
import { HttpClientModule } from '@angular/common/http';
import { UserSearchComponent } from './view/user/search/user-search.component';
import { UserFormComponent } from './view/user/form/user-form.component';
import { UserService } from './service/user/user.service';
import { CommonModule } from '@angular/common';
import { MatTabsModule, MatSidenavModule, MatToolbarModule, MatButtonModule, MatIconModule, MatMenuModule } from '@angular/material';
import { RofileLayoutComponent } from './layout/rofile-layout.component';
import { RofileHeaderComponent } from './header/rofile-header.component';

@NgModule({
  declarations: [
    RofileComponent,
    RoleSearchComponent,
    RoleFormComponent,
    UserSearchComponent,
    UserFormComponent,
    RofileLayoutComponent,
    RofileHeaderComponent
  ],
  imports: [
    CommonModule,
    MatTabsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    BrowserModule,
    RofileRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule
  ],
  exports: [
    MatTabsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule
  ],
  providers: [
    RoleService,
    UserService
  ],
  bootstrap: [RofileComponent]
})
export class RofileModule { }
