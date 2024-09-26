rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /users/{user}/{documents=**} {
      allow read, write: if user == request.auth.uid;
    }
  }
}