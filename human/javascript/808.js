rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /msgs/{msgId} {
      allow read: if request.auth != null && 
          (get(/databases/$(database)/documents/chatRooms/$(roomId)).data.userA.id == request.auth.uid
          || get(/databases/$(database)/documents/chatRooms/$(roomId)).data.userB.id == request.auth.uid);
    }
  }
}