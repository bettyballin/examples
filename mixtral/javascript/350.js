const db = firebase.firestore();

// Create reference to 'editor' subcollection of your users
let editorRef = db.doc(`users/${user.uid}/editors`);

// Set new user role
editorRef.set({
  email: user.email,
  role: "reviewer",
  lastSession: Date.now()
})
.then(() => {
  console.log("Document successfully written!");
})
.catch((error) => {
  console.error("Error writing document: ", error);
});