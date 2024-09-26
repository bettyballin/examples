// Import the required Firebase modules
import firebase from 'firebase/app';
import 'firebase/auth';

// Initialize Firebase
firebase.initializeApp({
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  projectId: '<PROJECT_ID>',
});

// Define the authentication provider (e.g. Google, Facebook, etc.)
const provider = new firebase.auth.GoogleAuthProvider();

// Sign in with the popup
firebase.auth().signInWithPopup(provider).then((result) => {
  console.log('Login successful!');
  console.log(result);
}).catch((error) => {
  console.error('Error during login:', error);
});