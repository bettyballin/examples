class FirebaseAuthExample {
  constructor() {
    this.firebaseAuth = firebase.auth();
    this.token = null;
  }

  init() {
    this.firebaseAuth.authState.subscribe((user) => {
      if (user) {
        user.getIdToken().then(idToken => this.token = idToken);
      }
    });
  }
}

const example = new FirebaseAuthExample();
example.init();

// you can access the token like this:
// example.token