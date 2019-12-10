import { User } from '../user/user';

export class Role {
    id: string;
    createdAt: Date;
    createdBy: string;
    modifiedAt: Date;
    modifiedBy: string;
    code: string;
    role: string;
    description: string;
    users: User[];
}
