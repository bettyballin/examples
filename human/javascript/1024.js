rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /mail/{mailId} {
      allow read: if request.auth != null && request.auth.uid == resource.data.author;
      allow write: if request.auth != null && request.auth.uid == request.resource.data.author;
    }
  }
}