firebase.auth()
  .signInWithPopup(provider)
  .then((result) => {
    return firebase.auth().currentUser.getIdToken();
  })
  .then((idToken) => {
    // use this idToken
  })
  .catch((error) => {
    console.error(error);
  });