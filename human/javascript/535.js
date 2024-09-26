const rules = {
  "rules": {
    "admins": {
      ".read": false,
      ".write": false 
    },
    "posts": {
      ".read": true,
      ".write": "root.child('admins').child(auth.uid).val()" 
      ,
      "$postId": {
        "comments": {
          ".write": "auth != null" 
        }
      }
    }
  }
};

// Use JSON.stringify to make the rules executable
const executableRules = JSON.stringify(rules, null, 2);

console.log(executableRules);