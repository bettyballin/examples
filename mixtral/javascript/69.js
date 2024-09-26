const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp();

exports.createUser = functions.auth.user().onCreate((user) => {
  const userId = user.uid;

  return admin
    .database()
    .ref(`/users/${userId}`)
    .set({
      providerId: user.providerData[0].providerId,
      displayName: user.displayName || null
    });
});