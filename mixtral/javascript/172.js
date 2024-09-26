firebase
  .database()
  .ref(`/userList/${firebase.auth().currentUser?.uid}`)
  .once('value')
  .then((snapshot) => {
    console.log(snapshot.val());
  })
  .catch((error) => {
    console.error(error);
  });