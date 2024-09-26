
firebase.auth().onAuthStateChanged((user) => {
  if (user) {
    // User is signed in, see docs for a list of available properties
    // https://firebase.google.com/docs/reference/js/firebase.User
    console.log(user.uid);
    // Now you can read from the database as the authenticated user
  } else {
    // User is signed out
    console.log('User is not signed in');
  }
});

