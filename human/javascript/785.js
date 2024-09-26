rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /posts/{userId}/userPosts/{document=**} {
      allow read: if true;
      allow write, update, delete: if isSignedIn() && isSameUser(userId);
    }

    function isSignedIn() {
      return request.auth != null;
    }

    function isSameUser(userId) {
      return request.auth.uid == userId;
    }
  }
}