// Import the Firebase JavaScript library
import firebase from "firebase/app";

// Initialize the Firebase app
firebase.initializeApp({
  // Your Firebase project configuration
  apiKey: "<API_KEY>",
  authDomain: "<AUTH_DOMAIN>",
  projectId: "<PROJECT_ID>",
});

// Use the Firebase app to get permissions
firebase.app().getPermission()
  .then(permissions => {
    if (!permissions.includes('delete')) {
      throw new Error('You don\'t have permission to delete the app');
    }
    // Allow the user to delete the app
    console.log("User has permission to delete the app");
  })
  .catch(error => {
    console.error(error);
  });