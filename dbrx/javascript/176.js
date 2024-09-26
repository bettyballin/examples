rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /messages/{messageId} {
      allow read: if isAuthenticated() &&
        (request.auth.uid == resource.data.senderId ||
         request.auth.uid == resource.data.receiverId) && 
        exists(/databases/$(database)/documents/threads/$(resource.data.threadId));
    }
  }
}