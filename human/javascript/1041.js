firebase.firestore().collection("reviews").doc(reviewId).get().then((doc) => {
  if (doc.exists) {
    console.log("Document data:", doc.data());
  } else {
    console.log("No such document!");
  }
}).catch((error) => {
  console.log("Error getting document:", error);
});

// Security rule
match /(path=**)/reviews/{reviewId} {
  allow read;
}