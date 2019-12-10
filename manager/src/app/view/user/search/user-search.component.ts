import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../service/user/user.service';
import { User } from '../../../model/user/user';
import { UserSearchCriteria } from '../../../model/user/user-search';
import { Router, ActivatedRoute } from '@angular/router';

@Component ({
  selector: 'app-user-search',
  templateUrl: './user-search.component.html',
  styleUrls: ['./user-search.component.css']
})
export class UserSearchComponent implements OnInit {

  users: User[];
  searchCriteria: UserSearchCriteria;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) {

  }

  ngOnInit() {
    this.searchCriteria = new UserSearchCriteria();
    this.userService.user = new User();
  }

  searchRoles() {
    this.userService.search(this.searchCriteria).subscribe(data => {
      this.users = data;
    });
  }

  editUser(user: User) {
    this.userService.user = user;
    this.router.navigate(['/adduser']);
  }

  removeUser(user: User) {
    const index = this.users.indexOf(user);
    this.userService.delete(user.id).subscribe(
      () => { console.log('User deleted.'); }
    );
    this.users.splice(index, 1);
  }
}
