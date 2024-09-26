
   service firebase.storage {
     match /b/{bucket}/o {
       // Matches any file in the storage
       match /{allPaths=**} {
         // Only allows read access if the user is authenticated
         allow read: if request.auth != null;
         // Only allows write access if the user is authenticated (optional)
         allow write: if request.auth != null;
       }
     }
   }
   
