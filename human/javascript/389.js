const firebaseConfig = {
  // Your Firebase configuration here
};

const firebase = require('firebase/app');
firebase.initializeApp(firebaseConfig);

const db = firebase.firestore();

const rules = {
  "rules": {
    "business": {
      ".indexOn": "\"city\""
    }
  }
};

db.enablePersistence()
  .then(() => {
    console.log('Persistence enabled');
  })
  .catch((error) => {
    console.error('Error enabling persistence:', error);
  });

db.collection('business').get()
  .then((snapshot) => {
    snapshot.forEach((doc) => {
      console.log(doc.id, '=>', doc.data());
    });
  })
  .catch((error) => {
    console.error('Error getting documents:', error);
  });