// Initialize Firebase
var firebaseConfig = {
  apiKey: "YOUR_API_KEY",
  authDomain: "YOUR_AUTH_DOMAIN",
  projectId: "YOUR_PROJECT_ID",
  storageBucket: "YOUR_STORAGE_BUCKET",
  messagingSenderId: "YOUR_MESSAGING_SENDER_ID",
  appId: "YOUR_APP_ID"
};
firebase.initializeApp(firebaseConfig);
const auth = firebase.auth();

auth.onAuthStateChanged(user => {
  if (user) {
    // User is signed in.
    console.log('User is logged in');
    window.location.replace('https://www.camisite.alenieto97.now.sh/home.html');
  } else {
    // No user is signed in.
    console.log('No user is currently logged in.');
  }
});

// Add login event
const btnLogin = document.getElementById('btnLogin');
const txtEmail = document.getElementById('txtEmail');
const txtPassword = document.getElementById('txtPassword');

btnLogin.addEventListener('click', e => {
  const email = txtEmail.value;
  const pass = txtPassword.value;

  auth.signInWithEmailAndPassword(email, pass)
    .then(() => console.log('Successfully signed in'))
    .catch(error => console.error(error.message));
});

// Add SignUp Event
const btnSignUp = document.getElementById('btnSignUp');

btnSignUp.addEventListener('click', e => {
  const email = txtEmail.value;
  const pass = txtPassword.value;

  auth.createUserWithEmailAndPassword(email, pass)
    .then(() => console.log('Successfully created user'))
    .catch(error => console.error(error.message));
});

// Add Logout Event
const btnLogOut = document.getElementById('btnLogOut');

btnLogOut.addEventListener('click', e => {
  firebase.auth().signOut();
});