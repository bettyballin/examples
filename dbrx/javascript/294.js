rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /Temp/{userId}/TopUp/{topUpDocId} {
      allow create: if request.auth != null &&
                     request.auth.uid == get(/databases/$(database)/documents/Devices/$(userId)).data.cashier_id;
    }
  }
}