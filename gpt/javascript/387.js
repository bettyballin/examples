
const createUserRoles = (email) => {
  console.log("Creating user roles in Firestore");
  const db = firebase.firestore(); // Get the Firestore database instance
  const editor = {
    email: email,
    role: "reviewer",
    lastSession: firebase.firestore.FieldValue.serverTimestamp(), // Use server timestamp
  };

  // Add a new document in collection "editors" with the user's email as the document ID
  // This assumes you want to use the email as a unique identifier for editors
  db.collection("editors").doc(email).set(editor)
    .then(() => {
      console.log("Document successfully written!");
    })
    .catch((error) => {
      console.error("Error writing document: ", error);
    });
};

