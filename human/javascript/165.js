var firebase = require('firebase');

firebase.initializeApp({
  // Your Firebase project configuration
});

var ref = firebase.database().ref('path/to/ref');

ref.transaction(function(currentValue) {
  return (currentValue || 0) + 1;
}, function(error, committed, snapshot) {
  if (error) {
    console.log('Transaction failed:', error);
  } else if (!committed) {
    console.log('Transaction failed too many times');
  } else {
    console.log('Transaction succeeded:', snapshot.val());
  }
});