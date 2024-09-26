const rules = {
  "rules": {
    "profile_pictures": {
      "$userId": {
        ".write": "root.child('users').child(auth.uid).child('userId').val() == $userId"
      }
    }
  }
};

console.log(JSON.stringify(rules, null, 2));