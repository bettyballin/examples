This is not JavaScript code, but rather Firestore Security Rules. However, I can help you make it executable by ensuring it's properly formatted. Here is the corrected version:



service cloud.firestore {
  match /databases/{database}/documents {
    // Allow read/write access on all documents in a collection
    // only if the requesting user's ID matches the document ID

    function isOwner(userId) {
      return userId == request.auth.uid;
    }

    match /users/{user} {
      allow create: if true;

      // Allow read/write access to a specific user
      allow read, write: if isOwner(user);

      // For subcollections within the users collection
      match /{document=**} {
        allow read, write: if request.auth != null && isOwner(parent().id);
      }
    }

    // Other collections or rules can be added here
  }
}