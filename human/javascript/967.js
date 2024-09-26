rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /mycollection/{userId} {
      allow read, update, delete: if resource.data.user == request.auth.token.email;
      allow create, update: if request.auth.token.email != null;
    }
  }
}