// No changes needed, this is a Firestore security rules file, not a JavaScript file.
// However, I can provide a JavaScript code that uses the Firestore security rules.

// Assuming you have the Firebase JavaScript SDK installed and configured.
const firebase = require('firebase/app');
const firestore = require('firebase/firestore');

firebase.initializeApp({
  // Your Firebase project configuration
});

const db = firebase.firestore();

// Set the security rules
const rules = `
  rules_version = '2';
  service cloud.firestore {
    match /databases/{database}/documents {
      match /{document=**} {
        allow read write: if request.auth.token.uid == resource.data.owner;
      }
    }
  }
`;

// Update the security rules
db.securityRules.update(rules).then(() => {
  console.log('Security rules updated successfully');
}).catch((error) => {
  console.error('Error updating security rules:', error);
});