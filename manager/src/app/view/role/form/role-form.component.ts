import { Component, OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RoleService } from '../../../service/role/role.service';
import { Role } from '../../../model/role/role';

@Component({
  selector: 'app-role-form',
  templateUrl: './role-form.component.html',
  styleUrls: ['./role-form.component.css']
})
export class RoleFormComponent implements OnInit {

  role: Role;

  constructor(private route: ActivatedRoute, private router: Router, private roleService: RoleService) {
    this.role = new Role();
  }

  ngOnInit(): void {
    this.role = this.roleService.role;
    if (this.role == null) {
      this.role = new Role();
      this.role.users = [];
    }
  }

  public saveRole() {
    this.roleService.save(this.role).subscribe(result => {
      this.role = result;
    });
  }

  public newRole() {
    this.role = new Role();
    this.role.users = [];
  }

  public gotoRoleList() {
    this.router.navigate(['/roles']);
  }
}
