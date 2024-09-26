
const admin = require('firebase-admin');

admin.auth().setCustomUserClaims(uid, { customUserId: "foobargayid123456" }).then(() => {
  // The custom claim is set,
