const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp();

exports.logSuccessfulAuth = functions.auth.user().onCreate((user) => {
  const authLogRef = admin.firestore().collection('authLogs').doc();
  return authLogRef.set({
    userId: user.uid,
    timestamp: admin.firestore.FieldValue.serverTimestamp(),
    type: 'successful'
  });
});