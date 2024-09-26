const firebaseConfig = {
  // Your Firebase config goes here
};

firebase.initializeApp(firebaseConfig);

const db = firebase.database();

const rules = {
  "rules": {
    "users": {
      ".indexOn": ["username"],
      "$someUid": {
        "$other" : {
          ".read": "($other == 'profile_picture' || $other == 'activeConversations') || auth.uid == $someUid", 
          ".write": "($other == 'profile_picture' || $other == 'activeConversations') || auth.uid == $someUid", 
        }
      }
    },
    "$anythingelse": {
      ".read": "auth != null",
      ".write": "auth != null",
    }
  }
};

db.ref('.info/rules').set(rules);