rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{path=**}/collection-colors/{doc} {
      allow read: if true;
    }
  }
}