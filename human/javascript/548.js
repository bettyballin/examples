const firebase = require('firebase-admin');
const db = firebase.database();

const rules = {
  ".read": true,
  ".write": true,
  "newuser": {
    "$pushid" : {
      ".validate": "root.child('users/'+newData.child('tagid').val()).val() === null"
    }
  }
};

db.ref('.info/rules').set(rules);