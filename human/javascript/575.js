rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, update, delete: if request.auth != null && (resource.data.members[request.auth.uid] == true || resource == null);
    }
  }
}