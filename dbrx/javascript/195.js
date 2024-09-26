// Not a JavaScript code, but rather a Firestore security rule.
// However, to make it clear, here is how you might use it in a JavaScript file to set security rules for Firestore:

const firebase = require('firebase-admin');
const firestore = firebase.firestore();

const securityRules = `
service cloud.firestore {
  match /databases/{database}/documents {
    match /users/{userId} {
      allow read, write: if request.auth.uid == userId;
    }
  }
}
`;

// Note: This requires the @google-cloud/firestore package and the @firebase/rules-unit-testing package.
const test = new firebase.rules.UnitTest();
test.setRules(securityRules);