const rules = {
  "rules": {
    "users": {
      "$uid": {
        ".write": "$uid === auth.uid",
        "followers": {
          ".write": "auth != null"
        }
      }
    }
  }
};

console.log(JSON.stringify(rules, null, 2));