// Import Firebase and Firebase Simple Login libraries
var Firebase = require('firebase');
var FirebaseSimpleLogin = require('firebase-simple-login');

// Initialize Firebase and Firebase Simple Login
var URL = 'https://your-firebase-url.firebaseio.com/'; // Replace with your Firebase URL
var fb = new Firebase(URL);
var auth = new FirebaseSimpleLogin(fb, function(err, user) {
   if( err ) throw err;
   if( user ) init(user);
});

// Define the init function
function init(user) {
   fb.child('buttonClicksByBrowserSession/'+user.uid).transaction(function(currValue) {
      return (currValue||0)+1;
   });
}

// Log in anonymously
auth.login('anonymous', {rememberMe: false});