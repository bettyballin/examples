firebase.auth().signInWithCustomToken(token).then(() => {
  firebase.auth().onAuthStateChanged(user => {
    if (user) {
      // User is signed in.
      loadAccountLock(brandAddress);
    } else {
      // No user is signed in.
      console.log("No user is signed in.");
    }
  });
}).catch(error => {
  console.error("Error signing in with custom token:", error);
});