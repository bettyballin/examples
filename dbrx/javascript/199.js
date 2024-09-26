// Import the Firebase library
import firebase from "firebase/app";
import "firebase/auth";

// Initialize the Firebase app
firebase.initializeApp({
  apiKey: "<API_KEY>",
  authDomain: "<AUTH_DOMAIN>",
  projectId: "<PROJECT_ID>",
});

// Make sure the Firebase auth library is initialized
firebase.auth();

// Now the original code should work
firebase.auth().onAuthStateChanged(user => {
  console.log('User signed in:', user);
});