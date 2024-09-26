// There is no direct JavaScript equivalent for the provided Firebase Security Rules code.
// However, here's an example of how you might implement similar authentication checks in a Node.js server using Firebase Authentication and Firestore:

const admin = require('firebase-admin');
admin.initializeApp();

const db = admin.firestore();

async function createDocument(userId, documentPath, data) {
  const user = await admin.auth().getUser(userId);
  if (user) {
    await db.doc(`Users/${userId}/${documentPath}`).set(data);
    return 'Document created successfully';
  } else {
    return 'Unauthorized: User is not authenticated';
  }
}

// Example usage:
createDocument('someUserId', 'someDocumentPath', { foo: 'bar' })
  .then((message) => console.log(message))
  .catch((error) => console.error(error));