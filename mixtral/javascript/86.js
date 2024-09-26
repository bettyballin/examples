$(document).ready(function() {
  // Monitoring User Authentication State

  function authDataCallback(user) {
    if (user) {
      console.log("User " + user.uid + " is logged in");
    } else {
      console.log("User is logged out");
    }
  }

  var ref = firebase.database().ref();

  // Register the callback to be fired every time auth state changes
  firebase.auth().onAuthStateChanged(authDataCallback);

  $("#logout").click(() => {
    firebase.auth().signOut()
      .then(() => console.log("User signed out"))
      .catch((error) => console.log(`Sign Out Error: ${error}`));

    ref.offAuth(authDataCallback);
  });

  // LOGIN

  function authHandler(user, error) {
    if (error) {
      console.log("Login Failed!", error);
    } else {
      console.log(`User ${user} authenticated successfully`);
    }
  }

  $("#login").click(() => {
    var _username = $('#Door').val();
    // Assuming you have a function to hash passwords
    let hashedPassword = hashFunction($('#Code').val());

    firebase.auth().signInWithEmailAndPassword(_username, hashedPassword)
      .then((userCredential) => {
        var user = userCredential.user;
        authHandler(user);
      })
      .catch((error) => {
        var errorCode = error.code;
        var errorMessage = error.message;
        authHandler(null, error);
      });
  });
});