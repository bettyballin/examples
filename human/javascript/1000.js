import {
  getAuth,
  signInWithEmailAndPassword,
  initializeApp
} from "https://www.gstatic.com/firebasejs/9.6.11/firebase-auth.js";

const firebaseConfig = {
  apiKey: "YOUR_API_KEY",
  authDomain: "YOUR_AUTH_DOMAIN",
  projectId: "YOUR_PROJECT_ID",
};

const app = initializeApp(firebaseConfig);
const auth = getAuth(app);

signInWithEmailAndPassword(auth, "user@domain.tld", "password").then((user) => {
  // read data using Firebase Realtime Database SDK
  console.log(user);
}).catch((error) => {
  console.error(error);
});