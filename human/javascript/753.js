const firebaseConfig = {
  // Your Firebase project configuration
};

const firebase = require('firebase/app');
const firebaseDatabase = require('firebase/database');

firebase.initializeApp(firebaseConfig);

const db = firebaseDatabase.getDatabase();

const rules = {
  "rules": {
    "users": {
       ".indexOn": ".value"
     }
  }
};

db.ref('.info/rules').set(rules);