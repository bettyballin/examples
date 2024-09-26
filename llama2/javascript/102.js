// Import the Firebase Firestore library
import { getFirestore } from 'firebase/firestore';

// Initialize the Firestore database
const db = getFirestore();

// Define the item variable
const item = 'example-item';

// Get a reference to the document
const docRef = db.collection("equipment").doc(item);

// Get the document
docRef.get().then((doc) => {
  if (!doc.exists) {
    // Add new item to existing document reference
    docRef.set({
      // Define the data to add
      name: item,
      quantity: 1
    });
  }
}).catch((error) => {
  console.log(error);
});