const functions = require('firebase-functions');
const { Firestore } = require('@google-cloud/firestore');

// Initialize a new instance of the Cloud Firestore client with limited privileges.
const firestoreWithLimitedPrivileges = new Firestore({
  projectId: 'your-project-id',
  credentials: {
    private_key_id: '<private-key-id>',
    private_key: '<private-key>',
    // ... other required fields
  }
});

exports.onTestRights = functions.firestore
  .document('init/{initID}')
  .onCreate((snap, context) => {
    const initID = context.params.initID;

    return firestoreWithLimitedPrivileges.collection('test').doc(initID).set({'random key': 'random value'}).then(() => {
      console.log('working');
      return;
    }).catch((err) => {
      console.log('error:', err);
      return;
    });
  });