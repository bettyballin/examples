// Initialize the app with a service account, granting admin privileges
var firebase = require('firebase-admin');

firebase.initializeApp({
  databaseURL: "https://databaseName.firebaseio.com",
  credential: require('path/to/serviceAccountCredentials.json')
});