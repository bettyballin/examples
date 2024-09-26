This is not JavaScript code, but rather a Firestore security rules configuration. However, I can provide you with the corrected version:


rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /users/{userDocId} {
      allow read, write: if request.auth != null;
    }
    match /products/{productDocId} {
      allow read, write: if request.auth.token.email == resource.data.userId;
    }
  }
}


Note that this is not executable JavaScript code, but rather a configuration file for Firestore security rules. If you want to use this in a JavaScript environment, you would need to use the Firestore SDK to set these rules programmatically. Here is an example of how to do that:


const firebase = require('firebase/app');
const firestore = require('firebase/firestore');

firebase.initializeApp({
  // Your Firebase project configuration
});

const db = firebase.firestore();
const rules = `
  rules_version = '2';
  service cloud.firestore {
    match /databases/{database}/documents {
      match /users/{userDocId} {
        allow read, write: if request.auth != null;
      }
      match /products/{productDocId} {
        allow read, write: if request.auth.token.email == resource.data.userId;
      }
    }
  }
`;

db.rulesets().create(rules).then(() => {
  console.log('Rules created');
}).catch((err) => {
  console.error('Error creating rules:', err);
});