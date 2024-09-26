class SecurityContextHolder {
  static getContext() {
    return new SecurityContext();
  }
}

class SecurityContext {
  getAuthentication() {
    return new Authentication();
  }
}

class Authentication {
  constructor() {
    this.name = 'John Doe';
    this.authorities = ['ROLE_USER'];
  }
}

console.log(SecurityContextHolder.getContext().getAuthentication());