rules_version = '2';
service cloud.firestore {
    match /databases/{database}/documents {
        function isSignedIn() {
            return request.auth != null;
        }

        // Allow read if the user is signed-in
        match /collectionName/documentId {
          allow read: if isSignedIn();
        }
    }
}