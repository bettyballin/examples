const credential = firebase.auth.GoogleAuthProvider.credential(null, jwtToken);
firebase.auth().signInWithCredential(credential)
  .then((userCreds) => {
    // User is signed in with Firebase JS SDK

    console.log(`User ID: ${userCreds.uid}`);

    firebase.database()
      .ref('/path/to/data')
      .orderByChild('userId').equalTo(userCreds.uid)
      // ...
  })
  .catch((error) => {
    console.error(error);
  });