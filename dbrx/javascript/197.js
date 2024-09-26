rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /chatRooms/{roomId}/msgs/{msgId} {
      allow read: if request.auth.uid in resource.data.ids;
    }
  }
}