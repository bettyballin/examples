const firebase = require('firebase');

const db = firebase.initializeApp({
  // Your Firebase config
}).database();

const rules = {
  "rules": {
    ".read": true,
    "someData": {
      "$anyKey": {
        ".write": true,
        ".validate": "newData.hasChild('myNewData')"
      }
    }
  }
};

db.ref('/').set({
  someData: {
    key1: {
      myNewData: 'Hello, World!'
    },
    key2: {
      invalidData: 'This should fail'
    }
  }
}, (error) => {
  if (error) {
    console.log('Error:', error);
  } else {
    console.log('Data saved successfully');
  }
});

db.ref('/someData/key2').set({
  myNewData: 'This should succeed'
}, (error) => {
  if (error) {
    console.log('Error:', error);
  } else {
    console.log('Data saved successfully');
  }
});