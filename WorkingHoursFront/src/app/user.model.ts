import {Role} from './role.model';
import {WorkPosition} from './workposition.model';
export class User {
	userId?: number;
    firstName?: string;
    lastName?: string;
    email?: string;
    username?: string;
    password?: string;
    phoneNumber?: string;
    checked?: boolean;
    role?: Role;
    position?: WorkPosition;
    
}
