this.fireauth.onAuthStateChanged((user) => {
  console.log(`User UID: ${user?.uid}`);
  // ...
});