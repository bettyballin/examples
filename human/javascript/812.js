const json = {
  /* Visit https://firebase.google.com/docs/database/security to learn more about security rules. */
  "rules": {
    ".read": "auth != null",
    ".write": "auth != null",
    "Alerts": {
      "BR": {
        "AC": {
          ".indexOn": ["end"]
        },
        "AM": {
          ".indexOn": ["end"]
        },
        "MS": {
          ".indexOn": ["end"]
        },
        "MT": {
          ".indexOn": ["end"]
        },
        "RO": {
          ".indexOn": ["end"]
        },
        "RR": {
          ".indexOn": ["end"]
        }
      }
    }
  }
};

console.log(JSON.stringify(json, null, 2));