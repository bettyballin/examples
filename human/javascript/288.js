// security-rules.js

const securityRules = {
  "rules": {
    ".read": false,
    ".write": false,
    "users": {
      "$userid": {
        ".read": "auth.uid == $userid",
        ".write": "auth.uid == $userid",
        "properties": {
          ".read": "root.child('users').child(auth.uid).child('children').hasChild($userid)"
        }
      }
    }
  }
};

module.exports = securityRules;



// index.js

const { initializeApp } = require('firebase/app');
const { getFirestore, doc, getDoc } = require('firebase/firestore');
const securityRules = require('./security-rules');

const app = initializeApp({
  // Your Firebase project configuration
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  projectId: '<PROJECT_ID>',
});

const db = getFirestore(app);

// Test the security rules
const userId = 'some-user-id';
const docRef = doc(db, `users/${userId}/properties`);
getDoc(docRef).then((docSnap) => {
  if (docSnap.exists()) {
    console.log('Document exists and can be read');
  } else {
    console.log('Document does not exist or cannot be read');
  }
}).catch((error) => {
  console.error('Error reading document:', error);
});