// Assuming you have the Firebase Realtime Database SDK included
var firebase = require('firebase/app');
require('firebase/database');

// Initialize Firebase
var config = {
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  databaseURL: '<DATABASE_URL>',
  projectId: '<PROJECT_ID>',
  storageBucket: '<STORAGE_BUCKET>',
  messagingSenderId: '<MESSAGING_SENDER_ID>'
};
firebase.initializeApp(config);

var databaseRef = firebase.database().ref();
var userId = 'your_user_id'; // Replace with the actual user ID

var messageRef = databaseRef.child(`/messagesThread/-KdzCvVW5icW7ZuSIAxV`);

messageRef
  .orderByChild("readBy/" + userId)
  .equalTo(false)
  .on("child_added", (snapshot) => {
    console.log(`Unread messages = ${snapshot.numChildren()}`);
  });