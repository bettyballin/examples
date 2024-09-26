const functions = require('firebase-functions');
const app = require('express')();
const firebase = require('firebase/app');
require('firebase/firestore');

var config = {
  apiKey: "YOUR_API_KEY",
  authDomain: "YOUR_AUTH_DOMAIN",
  databaseURL: "YOUR_DATABASE_URL",
  projectId: "YOUR_PROJECT_ID"
};
firebase.initializeApp(config);

let db = firebase.firestore();

app.post('/write', (req, res) => {
  let docRef = db.collection('test').doc("initID");

  return docRef
    .set({ 'random key': 'random value' }, { merge: true })
    .then(() => {
      console.log('working');
      res.status(204).send();
    })
    .catch((err) => {
      console.error("Error writing document:", err);
      res.status(500).send(err);
    });
});

exports.api = functions.https.onRequest(app);