this.angularFireAuth.onAuthStateChanged(user => {
  firebase
    .database()
    .ref('users')
    .child(user.uid)
    .child('email')
    .set('test@test.com');
});