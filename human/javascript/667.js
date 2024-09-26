const rules = {
  "rules": {
    "info": {     
      ".read": true,
      "$uid": {
        ".write": "$uid === auth.uid"
      }     
    }
  }
};

console.log(JSON.stringify(rules, null, 2));