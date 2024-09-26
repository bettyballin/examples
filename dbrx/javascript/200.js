const uid = firebase.auth().currentUser.uid;
db.ref(`units`).orderByChild('userEmail').equalTo(uid).on('value', (snapshot) => {
  console.log(snapshot.val());
});