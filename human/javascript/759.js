this.angularFireAuth.getRedirectResult().then(credential => {
  firebase
    .database()
    .ref('users')
    .child(credential.user.uid)
    .child('email')
    .set('test@test.com');
});