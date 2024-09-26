
this.firebaseAuth.authState.subscribe(user => {
  if (user) {
    user.getIdToken().then(idToken => {
      const httpOptions = {
        params: new HttpParams().set('auth', idToken)
      };
      return this.http.get(`https://myapp.firebaseio
