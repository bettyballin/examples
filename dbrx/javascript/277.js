// Import the Firebase JavaScript library
const firebase = require("firebase/app");
require("firebase/auth");

// Initialize Firebase
firebase.initializeApp({
  apiKey: "<API_KEY>",
  authDomain: "<AUTH_DOMAIN>",
  projectId: "<PROJECT_ID>",
});

const uid = '121212';
firebase.auth().createCustomToken(uid)
  .then((customToken) => {
    // Send this to your client and use it in signInWithCustomToken()
    firebase.auth().signInWithCustomToken(customToken)
      .then((userCredential) => {
        // Signed in
        const user = userCredential.user;
        console.log(`User signed in: ${user}`);
      })
      .catch((error) => {
        // Handle Errors here.
        const errorCode = error.code;
        const errorMessage = error.message;
        if (errorCode === 'auth/invalid-custom-token') {
          alert('The custom token format is incorrect.');
        } else {
          console.error(error);
        }
      });
  })
  .catch((error) => {
    console.error(`Error creating custom token: ${error}`);
  });