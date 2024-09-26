var firebase = require("firebase/app");
require("firebase/database");

// Initialize Firebase
firebase.initializeApp({
  apiKey: "<API_KEY>",
  authDomain: "<AUTH_DOMAIN>",
  databaseURL: "<DATABASE_URL>",
  projectId: "<PROJECT_ID>",
  storageBucket: "<STORAGE_BUCKET>",
  messagingSenderId: "<MESSAGING_SENDER_ID>",
});

firebase.database()
  .ref('/users')
  .orderByValue()
  .endAt(7000)
  .once('value')
  .then(function(results) {
    results.forEach(function(snapshot) {
      console.log(snapshot.key+": "+snapshot.val());
    });
  })
  .catch(function(error) {
    console.error("Error:", error);
  });