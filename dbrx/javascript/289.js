rules_version = '2';
service firebase.storage {
  match /b/{bucket}/o {
    match /images/{allImages=**} {      
      allow read: if request.auth != null;
    }
  }
}