import { initializeApp } from "firebase/app";
import { getAuth, onAuthStateChanged } from "firebase/auth";
import { getFirestore, collection, getDocs } from "firebase/firestore";

const firebaseConfig = {
  // your firebase config here
};

const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
const db = getFirestore(app);

//listen for auth status
onAuthStateChanged(auth, async(user) => {
  console.log(user);
  if (user) {
    const querySnapshot = await getDocs(collection(db, "Recipes"));
    setupRecipes(querySnapshot);
    setupUI(user);
  } else {
    setupRecipes([]);
    setupUI();
  }
});

function setupRecipes(querySnapshot) {
  // your setupRecipes function implementation here
}

function setupUI(user) {
  // your setupUI function implementation here
}