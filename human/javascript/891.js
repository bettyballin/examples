function isSignedIn() {
  return request.auth.uid !== null;
}

function isOwnerOfContent(userId){
  return request.auth.uid === userId;
}

match /Users/{userId}/{documents=**} {
  allow read, write: if isSignedIn() && isOwnerOfContent(userId);
}