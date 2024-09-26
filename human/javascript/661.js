// constants.js
export const ConstValue = { 
    ReturnUrl: "returnUrl",
    CurrentUser: "currentUser",    
}

export const ConstRoutingValue = {
    Login: "login"
}

// interfaces.js
export interface AICreateUser {
    firstName: string;
    lastName: string;
    email: string;
    password: string;    
    roleIds: string[]
}

export interface PartnerUser extends AICreateUser {
    id: string;    
    createdAt: string;    
    token: string;    
    featureSet: string[]
}

export interface AuthDto {
    email: string;
    password: string;
}

// main.js
import { ConstValue, ConstRoutingValue } from './constants';
import { AICreateUser, PartnerUser, AuthDto } from './interfaces';

// Example usage
console.log(ConstValue.ReturnUrl); // outputs: returnUrl
console.log(ConstRoutingValue.Login); // outputs: login

const createUser: AICreateUser = {
    firstName: 'John',
    lastName: 'Doe',
    email: 'john.doe@example.com',
    password: 'password123',
    roleIds: ['admin']
};

const partnerUser: PartnerUser = {
    ...createUser,
    id: '123',
    createdAt: '2022-01-01T00:00:00.000Z',
    token: 'token123',
    featureSet: ['feature1', 'feature2']
};

const authDto: AuthDto = {
    email: 'john.doe@example.com',
    password: 'password123'
};

console.log(createUser);
console.log(partnerUser);
console.log(authDto);