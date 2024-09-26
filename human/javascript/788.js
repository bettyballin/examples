rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    
    match /users/{user} {
      allow read: if true;  
      allow write: if request.auth != null && request.auth.uid == user;
    }
    
    match /templates/{template} {
      allow read: if true;  
      allow write: if request.auth != null && request.auth.uid == template;
    }
  }
}