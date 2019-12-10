import { Role } from '../role/role';

export class User {
    id: string;
    createdAt: Date;
    createdBy: string;
    modifiedAt: Date;
    modifiedBy: string;
    status: string;
    firstname: string;
    surname: string;
    username: string;
    password: string;
    confirmPassword: string;
    email: string;
    roles: Role[];
    //photo:
}
