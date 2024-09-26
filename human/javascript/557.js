const rules = {
  ".read": "auth != null && auth.provider == 'password'",
  "anonymousBundles": {
    ".read": "auth != null"
  }
};

console.log(rules);