// Assuming you are using Firebase Realtime Database
var firebaseConfig = {
  // your firebase configuration
};
firebase.initializeApp(firebaseConfig);

var database = firebase.database();
var user = firebase.auth().currentUser;

database.ref("notes")
  .orderByChild("access/author")
  .equalTo(`${user.uid}`)
  .once("value", function(data) {
    console.log(data.val());
  });