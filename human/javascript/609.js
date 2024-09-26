const firebase = require('firebase');

const config = {
  // Your Firebase project configuration
};

firebase.initializeApp(config);

const db = firebase.database();

const rules = {
  "rules": {

    "Stuff": {
      "$someName": {
        ".read": "root.child('Users').child(auth.uid).child('accesTo').val() == $someName"
      }
    },

    // ...etc... other rules for other tables in your database

  }
};

db.ref('/').update(rules);