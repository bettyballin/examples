const firebase = require('firebase/app');
const firebaseDatabase = require('firebase/database');

firebase.initializeApp({
  // Your Firebase project configuration
});

const dataBase = firebase.database().ref('/myPath');
const payload = { /* your payload object */ };

dataBase.set(payload, error => {
  if (error) {
    return console.log(`Error writing to database ${error}`);
  }
});