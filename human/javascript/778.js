// This is a Firestore security rules file, not a JavaScript file.
// However, I will provide the equivalent JavaScript code to implement the same logic.

const admin = require('firebase-admin');
const firebase = require('firebase/app');
require('firebase/firestore');

admin.initializeApp();
firebase.initializeApp(admin.app().options);

const db = admin.firestore();
const auth = firebase.auth();

async function authorizeUserRead(userID) {
  const user = auth.currentUser;
  if (user && user.uid === userID) {
    return true;
  } else {
    throw new Error('Unauthorized');
  }
}

async function authorizeUserWrite(userID) {
  const user = auth.currentUser;
  if (user && user.uid === userID) {
    return true;
  } else {
    throw new Error('Unauthorized');
  }
}

async function readUserDocument(userID) {
  await authorizeUserRead(userID);
  return db.collection('users').doc(userID).get();
}

async function writeUserDocument(userID, data) {
  await authorizeUserWrite(userID);
  return db.collection('users').doc(userID).set(data);
}

// Example usage:
readUserDocument('exampleUserID')
  .then((doc) => console.log(doc.data()))
  .catch((error) => console.error(error));

writeUserDocument('exampleUserID', { name: 'John Doe' })
  .then(() => console.log('Document written successfully'))
  .catch((error) => console.error(error));