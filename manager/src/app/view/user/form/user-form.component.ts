import { Component, OnInit } from '@angular/core';
import { User } from '../../../model/user/user';
import { UserService } from '../../../service/user/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Role } from '../../../model/role/role';
import { RoleService } from '../../../service/role/role.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  user: User;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService, private roleService: RoleService) {
  }

  ngOnInit() {
    this.user = this.userService.user;
    if (this.user == null) {
      this.user = new User();
      this.user.roles = [];
    }
  }

  public saveUser() {
    this.userService.save(this.user).subscribe(result => {
      this.user = result;
    });
  }

  public newUser() {
    this.user = new User();
    this.user.roles = [];
  }

  public addRoleToUser(role: Role)
  {
    this.user.roles.push(role);
  }

  public removeRoleFromUser(role: Role)
  {
    const index = this.user.roles.indexOf(role);
    this.user.roles.splice(index, 1);
    this.roleService.save(role).subscribe(() => {
      console.log('Role removed from user.');
    });
  }

  public gotoUserList() {
    this.router.navigate(['/users']);
  }
}
