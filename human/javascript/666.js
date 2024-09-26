class User {}

class Router {
  navigate(route) {
    console.log(`Navigating to ${route}`);
  }
}

class AuthService {
  _currentUser;

  get currentUser() {
    return this._currentUser;
  }

  set currentUser(user) {
    this._currentUser = user;
    this.currentUserSubject.next(user);
  }

  get currentUserValue() {
    return this._currentUser;
  }

  currentUserSubject = {
    subscribe: (callback) => {
      callback(this._currentUser);
    },
    next: (user) => {
      this._currentUser = user;
    },
  };

  logout() {
    this.currentUser = null;
  }
}

export class AppComponent {
  currentUser;

  constructor(router, authenticationService) {
    this.router = router;
    this.authenticationService = authenticationService;
    this.authenticationService.currentUserSubject.subscribe((x) => {
      this.currentUser = x;
    });
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(["/login"]);
  }
}

const router = new Router();
const authService = new AuthService();
const appComponent = new AppComponent(router, authService);

appComponent.logout();