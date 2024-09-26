firebase.database().ref().child('units').orderByChild('userEmail').equalTo(firebase.auth().currentUser.email).once('value', function(snapshot) {
  console.log(snapshot.val());
});