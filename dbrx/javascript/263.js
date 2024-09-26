This is not JavaScript code, but rather Firebase Firestore Security Rules. However, I can provide you with the corrected version:


rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {

    // Allow users to read and write their own documents in the "users" collection.
    match /users/{userEmail} {
      allow read, write: if request.auth != null && request.auth.token.email == userEmail;
    }

    // Allow authenticated users with admin claims access to all products
    match /products/{productId} {
      allow read, write: if request.auth != null && (request.auth.uid in resource.data.admins || request.auth.token.admin == true);
    }
  }
}


Note that I added a comma between `read` and `write` in the first `allow` statement, and also added `== true` to the `request.auth.token.admin` check in the second `allow` statement.