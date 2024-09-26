const admin = require('firebase-admin');
admin.initializeApp();

const db = admin.firestore();

async function addEntry(userId, data) {
  const userDocRef = db
    .collection("entries")
    .where('user', '==', userId)
    .where('active', '==', true);

  // Check if the document exists
  let querySnapshot = await userDocRef.get();

  if (!querySnapshot.empty) {
      throw new Error("User already has an active entry.");
  }

  const docId = db
    .collection('entries')
    .doc().id;

  // Add the document
  await db
    .collection('entries')
    .doc(docId)
    .set({
      user: userId,
      active: true,
      ...data
   });
}

// Call the function to test it
addEntry('testUserId', { test: 'data' })
  .then(() => console.log('Entry added successfully'))
  .catch(error => console.error(error));