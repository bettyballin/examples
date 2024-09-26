rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {

    // Allow read/write access to all documents under 'Stuff'
    // but only for users who have that specific role

    function isAllowed(role) {
      return request.auth != null &&
             (request.resource == null ||
              resource[role] in get(/databases/$(database)/documents/Users/$(request.auth.uid)).data.accessRoles);

     // Note: The above line assumes that the 'Stuff' document names are stored as keys under each user
    }

    match /Stuff/{stuffId} {
      allow read, write: if isAllowed('Stuff');
    }
  }
}