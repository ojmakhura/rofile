import { Component, OnInit } from '@angular/core';
import { Role } from '../../../model/role/role';
import { RoleService } from '../../../service/role/role.service';
import { RoleSearchCriteria } from '../../../model/role/role-search';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-role-search',
  templateUrl: './role-search.component.html',
  styleUrls: ['./role-search.component.css']
})
export class RoleSearchComponent implements OnInit {

  roles: Role[];
  searchCriteria: RoleSearchCriteria;

  constructor(private route: ActivatedRoute, private router: Router, private roleService: RoleService) { }

  ngOnInit() {
    this.searchCriteria = new RoleSearchCriteria();
    this.roleService.role = new Role();
    this.roles = [];
  }

  searchRoles() {
    this.roleService.search(this.searchCriteria).subscribe(data => {
      this.roles = data;
    });
  }

  editRole(role: Role) {
    this.roleService.role = role;
    this.router.navigate(['/addrole']);
  }

  deleteRole(role: Role) {
    const index = this.roles.indexOf(role);
    this.roleService.delete(role.id).subscribe(
      () => { console.log('Role deleted.'); }
    );
    this.roles.splice(index, 1);
  }
}
