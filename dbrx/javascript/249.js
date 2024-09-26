const db = firebase.firestore();
db.collection('editors').add({
  email: user.email,
  role: 'reviewer',
  lastSession: Date.now()
}).then(function(docRef) {
  console.log("Document written with ID: ", docRef.id);
}).catch(function(error) {
  console.error("Error adding document: ", error);
});