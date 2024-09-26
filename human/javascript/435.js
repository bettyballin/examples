function createModul(modulId, ref) {
  var modulRef = ref.child('moduls').child(modulId);
  modulRef.once('value', function(snapshot) {
    if (snapshot.exists()) {
      console.error('Modul with '+modulId+' already exists');
    }
    else {
      modulRef.set('My new value', function(error) {
        if (error) {
          console.error('Write failed, probably somebody created '+modulId+' in the meantime')
        }
      });
    }
  });
}

// example usage
var firebase = require('firebase');
firebase.initializeApp({
  // your firebase config
});
var ref = firebase.database().ref();
createModul('exampleModulId', ref);