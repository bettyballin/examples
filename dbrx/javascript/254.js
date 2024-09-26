This is not JavaScript code, but rather a Firestore security rules configuration. However, I'll provide the equivalent JavaScript code for the `isUniqueUser` function, assuming you want to use it in a Cloud Function or a client-side application:


const admin = require('firebase-admin');
admin.initializeApp();

const db = admin.firestore();

function isUniqueUser(userId, userData) {
  return db.collection('users')
    .where('user', '==', userData.user)
    .where('active', '==', true)
    .get()
    .then(querySnapshot => querySnapshot.empty);
}