// Import the Firebase JavaScript library
importScripts('https://www.gstatic.com/firebasejs/9.1.3/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/9.1.3/firebase-auth.js');

// Initialize Firebase
const firebaseConfig = {
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  projectId: '<PROJECT_ID>',
};

firebase.initializeApp(firebaseConfig);

// Make sure the Firebase Auth is initialized
firebase.auth().onAuthStateChanged(function(user) {
  if (user) {
    var uid = user.uid;
    console.log('User is signed in with UID: ' + uid);
  } else {
    console.log('User is not signed in.');
  }
});