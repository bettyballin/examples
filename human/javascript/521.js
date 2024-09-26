// Import the Firebase Realtime Database library
const firebase = require('firebase/app');
require('firebase/database');

// Initialize Firebase
firebase.initializeApp({
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  databaseURL: '<DATABASE_URL>',
  projectId: '<PROJECT_ID>',
  storageBucket: '<STORAGE_BUCKET>',
  messagingSenderId: '<MESSAGING_SENDER_ID>'
});

// Get a reference to the database
const db = firebase.database();
const ref = db.ref();

// Your original code
ref.child('items')
   .orderByChild('title')
   .startAt("Product 1")
   .endAt("Product 1")
   .limitToFirst(15)
   .on("child_added", function(snapshot) { console.log(snapshot.val()); });