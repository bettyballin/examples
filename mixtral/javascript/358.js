rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents/entries {
    allow create, update: if request.resource.data.active == true &&
      !exists(/databases/{database}/documents/entries.where('user', '==', request.resource.data.user).where('active', '==', true).get());
  }
}