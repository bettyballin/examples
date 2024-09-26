const firebase = require('firebase');

firebase.initializeApp({
  // Your Firebase project configuration
});

const db = firebase.database();

const rules = {
  "rules": {
    ".read": true,
    "someData": {
      "$anyKey": {
        ".write": true,
        ".validate": "newData.hasChild('myNewData')",
        "myNewData": {
          ".validate": "data.isString()"
        },
        "$other": {
          ".validate": false
        }
      }
    }
  }
};

db.ref('/').set(rules);