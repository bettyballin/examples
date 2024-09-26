rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {

    match /users/{userId} {
        match /groups/{groupId} {
           allow read: if userId == request.auth.uid;
        }
        match /events/{eventId} {
           allow read: if userId == request.auth.uid;
        }
    }

  }
}