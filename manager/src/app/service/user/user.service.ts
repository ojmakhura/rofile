import { Injectable } from '@angular/core';
import { User } from '../../model/user/user';
import { HttpClient } from '@angular/common/http';
import { UserSearchCriteria } from '../../model/user/user-search';
import { Observable } from 'rxjs';

@Injectable()
export class UserService {

  private usersUrl: string;
  user: User;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/rofile/users';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  public save(user: User): Observable<User> {
    if (user.id == null) {
      user.createdAt = new Date();
      user.createdBy = 'system';
    } else {
      user.modifiedAt = new Date();
      user.modifiedBy = 'system';
    }
    return this.http.post<User>(this.usersUrl, user);
  }

  public findById(id: string): Observable<User> {
    return this.http.get<User>(this.usersUrl + '/find/' + id);
  }

  public delete(id: string): Observable<void> {
    return this.http.delete<void>(this.usersUrl + '/delete/' + id);
  }

  public search(searchCriteria: UserSearchCriteria): Observable<User[]> {
    return this.http.post<User[]>(this.usersUrl + '/search/', searchCriteria);
  }
}
