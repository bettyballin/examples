
   service firebase.storage {
     match /b/{bucket}/o {
       // Allow write operation under the "invoices" directory for authenticated users
       // and ensure the file name matches the user's UID concatenated with ".pdf"
       match /invoices/{userId}/{invoiceId}.pdf {
         allow write: if request.auth != null && request.auth.uid == userId;
         allow read: if request.auth != null && (request.auth.uid == userId || isAdmin(request.auth.uid));
       }
     }
   }

   // Helper function to determine if the user is an admin
   function isAdmin(uid) {
     return uid == "your-admin-
