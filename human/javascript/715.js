// Import the required plugins
const cordova = require('cordova');
const firebase = cordova.plugins.firebase;

// Use the plugins
firebase.auth.signInWithVerificationId("djgfioerjg34", "123456");