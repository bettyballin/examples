import { getAuth, onAuthStateChanged, signInWithEmailAndPassword } from 'firebase/auth';

const auth = getAuth();

// Listen for changes in the authorization state
onAuthStateChanged(auth, (user) => {
  if (!user) return;

  // User is signed in.
});

// Example usage of signInWithEmailAndPassword
const email = 'your_email@example.com';
const password = 'your_password';

signInWithEmailAndPassword(auth, email, password)
  .then((userCredential) => {
    const user = userCredential.user;
    console.log('Signed in user:', user);
  })
  .catch((error) => {
    const errorCode = error.code;
    const errorMessage = error.message;
    console.error('Error signing in:', errorCode, errorMessage);
  });