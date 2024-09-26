// Import Firebase library
import firebase from "firebase/app";
import "firebase/auth";

// Initialize Firebase JS SDK with custom auth token
firebase.initializeApp({
  apiKey: "<API_KEY>",
  authDomain: "<AUTH_DOMAIN>",
  projectId: "<PROJECT_ID>",
});

firebase.auth().setPersistence(firebase.auth.Auth.Persistence.NONE);

const idToken = "<CUSTOM_ID_TOKEN>";
const credential = firebase.auth.EmailAuthProvider.credential(null, null);
credential.accessToken = idToken;

try {
  firebase.auth().signInWithCredential(credential)
    .then((userCredential) => {
      console.log(userCredential);
    })
    .catch((error) => {
      console.error(error);
    });
} catch (error) {
  console.error(error);
}