const admin = require('firebase-admin');
const functions = require('firebase-functions');

admin.initializeApp();

exports.logFailedAuth = functions.auth.user().onError((error) => {
  const authLogRef = admin.firestore().collection('authLogs').doc();
  return authLogRef.set({
    error: error.message,
    timestamp: admin.firestore.FieldValue.serverTimestamp(),
    type: 'failed'
  });
});