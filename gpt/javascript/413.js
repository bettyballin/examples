
const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
const db = getFirestore(app);

const recipeList = document.querySelector(".recipes");
const loggedOutLinks = document.querySelectorAll(".logged-out");
const loggedInLinks = document.querySelectorAll(".logged-in");

const setupUI = (user) => {
  if (user) {
    loggedInLinks.forEach((item) => (item.style.display = "block"));
    loggedOutLinks.forEach((item) => (item.style.display = "none"));
    setupRecipes(user); // Fetch recipes only when user is logged in
