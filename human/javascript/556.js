var ref = firebase.database().ref();

// read denied
ref.child('bundles').once('value')
  .then(data => console.log(data.val()))
  .catch(error => console.log('Error:', error));

// read allowed
ref.child(`bundles/-L-2BbIkAg6J9WPMaJpJ`).once('value')
  .then(data => console.log(data.val()))
  .catch(error => console.log('Error:', error));