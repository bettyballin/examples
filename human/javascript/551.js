Here is the executable code:


// Configure Firebase Client SDK.
const firebase = require('firebase/app');
require('firebase/auth');
require('firebase/firestore');
firebase.initializeApp({
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  projectId: '<PROJECT_ID>',
});

// Configure Firebase Admin SDK.
const admin = require('firebase-admin');
const serviceAccount = require('./serviceAccountKey.json');
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
});

// Create Custom Auth token for 'my-worker'.
const firebaseReady = admin.auth().createCustomToken('my-worker').then(token => {
  // Sign in the Client SDK as 'my-worker'
  return firebase.auth().signInWithCustomToken(token).then(user => {
    console.log('User now signed-in! uid:', user.uid);

    return firebase.firestore();
  });
});

// Now firebaseReady gives you a Promise that completes with a authorized firestore instance. Use it like this:

const functions = require('firebase-functions');
exports.onTestRights = functions.firestore
  .document('init/{initID}')
  .onCreate(event => {
    const initID = event.params.initID;
    return firebaseReady.then(db => db.collection('test').doc(initID).set({'random key': 'random value'}).then(() => {
      console.log('working');
      return;
    }).catch((err) => {
      console.log('error: ', err);
      return;
    });
  });
});