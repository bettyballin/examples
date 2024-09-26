// Import the Firebase JavaScript library
import firebase from "firebase/app";
import "firebase/database";

// Initialize the Firebase app
firebase.initializeApp({
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  databaseURL: '<DATABASE_URL>',
  projectId: '<PROJECT_ID>',
  storageBucket: '<STORAGE_BUCKET>',
  messagingSenderId: '<MESSAGING_SENDER_ID>',
});

let timestamp = Date.now();
firebase.database().ref('messages').push({
    text: 'Hello world',
    createdAt: timestamp
});