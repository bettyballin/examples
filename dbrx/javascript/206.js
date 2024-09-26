// Import the required Firebase modules
import { initializeApp } from 'firebase/app';
import { getFirestore, doc, getDoc } from 'firebase/firestore';

// Initialize Firebase
const firebaseConfig = {
  // Your Firebase project configuration
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  projectId: '<PROJECT_ID>',
};

const app = initializeApp(firebaseConfig);
const db = getFirestore(app);

// Assume 'user' is an object with a 'uid' property
const user = { uid: '<USER_UID>' };

async function getUserData() {
  const userRef = doc(db, 'Users', user.uid);
  try {
    const documentSnapshot = await getDoc(userRef);
    if (documentSnapshot.exists()) {
      console.log(documentSnapshot.data());
    }
  } catch (error) {
    console.error('Error getting user data:', error);
  }
}

// Call the function to get the user data
getUserData();