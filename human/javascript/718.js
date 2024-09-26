This is not JavaScript code, but rather Firebase Firestore Security Rules. However, I can provide you with the corrected version of the security rules:


service cloud.firestore {
  match /databases/{database}/documents {
    match /users/{userId} {
      allow read, write: if request.auth.uid == userId;
    }
    match /posts/{postId} {
      allow read, create: if request.auth.uid != null;
      allow update, delete: if resource.data.uid == request.auth.uid;
    }
    match /comments/{commentId} {
      allow read, create: if request.auth.uid != null;
      allow update, delete: if resource.data.uid == request.auth.uid;
    }
  }
}


Note that I replaced `get(/databases/$(database)/documents/posts/$(request.auth.uid)).data.uid` with `resource.data.uid` to access the `uid` field of the current document being updated or deleted.