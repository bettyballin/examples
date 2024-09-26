firebase.auth().signInAnonymously().then(() => {
  const user = firebase.auth().currentUser;
  user.updateProfile({ displayName: "VALU" }).then(() => {
    return user.getIdToken(true);
  }).then((idToken) => {
    const dbRef = firebase.database().ref(`lists/${SomeList}`);
    dbRef.on('value', (snapshot) => {
      console.log(snapshot.val());
    }, (error) => {
      console.error(error);
    });
  });
});