This is not JavaScript code, but rather Firebase Firestore Security Rules. However, I can provide you with the corrected version:


service cloud.firestore {
  match /databases/{database}/documents {

    // FUNCTIONS

    // True if the signed in user is the thing's user
    function isThingUser() {
      return request.auth != null && request.auth.uid != null && resource.data.user == request.auth.uid;
    }

    // True if the signed in user is the thing's owner
    function isThingOwner() {
      return request.auth != null && request.auth.uid != null && resource.data.owner == request.auth.uid;
    }

    // RULES

    // Things
    match /things/{thingID} {
      allow create: if true;
      allow read, update: if isThingUser() || isThingOwner();

      match /parts/{partID} {
        allow read, write: if true;
      }
    }
  }
}


Note that I replaced the HTML entity `&amp;` with the actual ampersand `&` and added semicolons at the end of each function.