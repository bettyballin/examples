const db = firebase.firestore();
const q = db.collection('your-collection').where('user', '==', 37870283).where('active', '==', true);

q.get().then((querySnapshot) => {
  // If there are any documents in the result set throw an error
  if (querySnapshot.docs.length > 0) {
    throw new firebase.firestore.FirestoreError('User already has active document');
  }

  // Otherwise create the new document
  db.collection('your-collection').add({
    user: 37870283,
    active: true
  });
}).catch((error) => {
  console.log(error);
});