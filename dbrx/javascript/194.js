const admin = require('firebase-admin');

admin.initializeApp();

const db = admin.firestore();

db.collection('userdata').get((id, email) => {
  const query = db.collection('userdata').where('id', '==', id).where('email', '==', email);
  query.get().then(querySnapshot => {
    if (!querySnapshot.empty) {
      console.log('Read access allowed');
    } else {
      console.log('Read access denied');
    }
  });
});