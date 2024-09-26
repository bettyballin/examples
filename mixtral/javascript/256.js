// Import the Firebase library
import firebase from "firebase/app";
import "firebase/functions";

// Initialize Firebase
firebase.initializeApp({
  apiKey: "YOUR_API_KEY",
  authDomain: "YOUR_AUTH_DOMAIN",
  projectId: "YOUR_PROJECT_ID",
});

// Create a Cloud Function reference
const checkUsernameAvailability = firebase.functions().httpsCallable('checkUsernameAvailability');

// Call the Cloud Function
checkUsernameAvailability({ username: 'desired_username' })
  .then(result => {
    console.log(`Is ${result.data.result ? '' : 'not'} available`);

    // Handle result
  })
  .catch(error => {
    console.error("Error checking username availability:", error);
  });