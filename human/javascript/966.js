rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /mycollection/{userId} {
      allow read, update, delete: if userId == request.auth.token.email;
      allow create, update: if userId == request.auth.token.email;
    }
  }
}