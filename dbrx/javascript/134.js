rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /authLogs/{log} {
      allow read: if request.auth != null;
      // Only authenticated users can view the logs but you might want more specific rules based on your use case.
    }
  }
}