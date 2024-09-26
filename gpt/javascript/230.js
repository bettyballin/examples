
firebase.auth().signInAnonymously()
  .then(() => {
    const user = firebase.auth().currentUser;
    if (user) {
      return user.updateProfile({
        displayName: "VALU"
      });
    } else {
      throw new Error('No user signed in.');
    }
  })
  .then(() => {
    // Force a token refresh to update the token with the new display name
   
