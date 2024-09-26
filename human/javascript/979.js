rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /fruits/{id} {
      allow get: true;
      allow list: false;
    }
  }
}