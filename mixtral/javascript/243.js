// Import the Firebase library
import firebase from 'firebase/app';
import 'firebase/auth';

// Initialize Firebase
firebase.initializeApp({
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  projectId: '<PROJECT_ID>',
});

// Check if a user is currently signed in
if (!firebase.auth().currentUser) {
  console.error("No current user found.");
} else {
  // Call your function here
  console.log("Current user found:", firebase.auth().currentUser);
}