
// On your server
const admin = require('firebase-admin');
admin.initializeApp({
  // Your Firebase service account config
});

const uid = '121212';
admin.auth().createCustomToken(uid)
  .then(customToken => {
    // Send this token to the client app
  })
  .catch(error => {
    console.log('Error creating custom token:', error);
  });

