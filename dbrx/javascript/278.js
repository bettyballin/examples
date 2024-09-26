// Import the Firebase JavaScript library
import firebase from "firebase/app";
import "firebase/database";

// Initialize Firebase
firebase.initializeApp({
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  databaseURL: '<DATABASE_URL>',
  projectId: '<PROJECT_ID>',
  storageBucket: '<STORAGE_BUCKET>',
  messagingSenderId: '<MESSAGING_SENDER_ID>',
  appId: '<APP_ID>'
});

// Set the UID
const uid = 'your_uid_here';

const dbRef = firebase.database().ref();
dbRef.child(uid).get()
  .then((snapshot) => {
    if (snapshot.exists()) {
      const value = snapshot.val();
      console.log('Data:', value);
    } else {
      console.log('No data available');
    }
  })
  .catch((error) => {
    console.error(error);
  });