This is not JavaScript code, but rather Firebase Firestore security rules. However, I can provide you with the equivalent JavaScript code to set these security rules:


const admin = require('firebase-admin');
admin.initializeApp();

const db = admin.firestore();

const setSecurityRules = async () => {
  await db.collection('users').doc('security-rules').set({
    rules: `
      service cloud.firestore {
        match /databases/{database}/documents {
          match /users/{userId}/{document=**} {
            allow read: if request.auth.uid == userId;
          }
        }
      }
    `,
  });
};

setSecurityRules().then(() => console.log('Security rules set'));