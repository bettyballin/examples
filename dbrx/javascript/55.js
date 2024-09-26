// Initialize Firebase app with your configuration details
var firebaseConfig = {
  apiKey: "YOUR_API_KEY",
  authDomain: "YOUR_AUTH_DOMAIN",
  projectId: "YOUR_PROJECT_ID",
  storageBucket: "YOUR_STORAGE_BUCKET",
  messagingSenderId: "YOUR_MESSAGING_SENDER_ID",
  appId: "YOUR_APP_ID"
};
firebase.initializeApp(firebaseConfig);

// Get a reference to the Firebase Authentication service
var auth = firebase.auth();

// Listen for changes in user authentication state
auth.onAuthStateChanged(function(user) {
  if (user) {
    // User is signed in.
    console.log("User " + user.uid + " is logged in with provider: " + user.providerData[0].providerId);
  } else {
    // User is signed out.
    console.log("User is not authenticated.");
  }
});

// Authenticate users using email/password
var userEmail = "user@example.com";
var userPassword = "user-password";
auth.signInWithEmailAndPassword(userEmail, userPassword).catch(function(error) {
  var errorCode = error.code;
  var errorMessage = error.message;

  if (errorCode === 'auth/wrong-password') {
    console.log('Wrong password.');
  } else {
    console.log(errorMessage);
  }
});

// Sign out the current authenticated user
function signOut() {
  auth.signOut().then(function() {
    // User is signed out.
    console.log("User has been logged out.");
  }).catch(function(error) {
    var errorMessage = error.message;

    if (errorMessage === 'auth/network-request-failed') {
      console.log('Network request failed. Please check your internet connection and try again.');
    } else {
      console.log(errorMessage);
    }
  });
}

// Call the signOut function
signOut();