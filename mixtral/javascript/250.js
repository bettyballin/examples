rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    function isChatPartner(chatRoom) {
      return chatRoom.recieverId == request.auth.uid ||
             chatRoom.senderId   == request.auth.uid;
    }

    match /chatRooms/{roomId} {
      allow read: if isChatPartner(resource.data);
      match /messages/{messageId} {
        // ...
      }
    }
  }
}