// Import the Firebase JavaScript library
import firebase from "firebase/app";
import "firebase/database";

// Initialize Firebase
firebase.initializeApp({
  apiKey: "<API_KEY>",
  authDomain: "<AUTH_DOMAIN>",
  databaseURL: "<DATABASE_URL>",
  projectId: "<PROJECT_ID>",
  storageBucket: "<STORAGE_BUCKET>",
  messagingSenderId: "<MESSAGING_SENDER_ID>",
});

// Get a reference to the "applications" node in the Realtime Database
const refApp = firebase.database().ref('applications');