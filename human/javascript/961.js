This is not JavaScript code, it's Firebase Firestore Security Rules. However, I can provide you with the corrected version:


rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if false;
    }
    match /TestCollection/{doc} {
      allow read: if true;
      allow write: if false;
    }
  }
}