rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /chatRooms/{roomId=**} {
      allow read: if request.auth.uid == resource.data.userA.id || 
                 request.auth.uid == resource.data.userB.id;
    }
  }
}