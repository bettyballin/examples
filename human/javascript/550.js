rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /families/{anyDocument} {
      allow read: if request.auth != null;
      allow write: if resource.data.parents.userId in [(request.auth.uid)];
    }
  }
}