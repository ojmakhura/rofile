import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Role } from '../../model/role/role';
import { Observable } from 'rxjs';
import { RoleSearchCriteria } from '../../model/role/role-search';

@Injectable()
export class RoleService {

  private rolesUrl: string;
  role: Role;

  constructor(private http: HttpClient) {
    this.rolesUrl = 'http://localhost:8080/rofile/roles';
  }

  public findAll(): Observable<Role[]> {
    return this.http.get<Role[]>(this.rolesUrl);
  }

  public save(role: Role): Observable<Role> {
    if (role.id == null) {
      role.createdAt = new Date();
      role.createdBy = 'system';
    } else {
      role.modifiedAt = new Date();
      role.modifiedBy = 'system';
    }
    return this.http.post<Role>(this.rolesUrl, role);
  }

  public findById(id: string): Observable<Role> {
    return this.http.get<Role>(this.rolesUrl + '/find/' + id);
  }

  public delete(id: string): Observable<void> {
    return this.http.delete<void>(this.rolesUrl + '/delete/' + id);
  }

  public search(searchCriteria: RoleSearchCriteria): Observable<Role[]> {
    return this.http.post<Role[]>(this.rolesUrl + '/search/', searchCriteria);
  }
}
