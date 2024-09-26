This is not JavaScript code, but rather a Firestore security rules configuration. However, I can provide you with the equivalent JavaScript code to set up these security rules using the Firebase Firestore SDK:


const firebase = require('firebase');
const firestore = firebase.firestore();

const setupSecurityRules = async () => {
  const rules = `
    service cloud.firestore {
      match /databases/{database}/documents {

        match /users/{userId} {
          allow read: if request.auth.uid == userId;

          match /practitionerClients/{clientId} {
            allow read: if request.auth.uid == userId;
          }

        }
      }
    }
  `;

  await firestore.securityRules().updateRules({ rules });
};

setupSecurityRules();