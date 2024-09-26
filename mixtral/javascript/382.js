onAuthStateChanged(auth, async (user) => {
  console.log(user);

  let querySnapshot;

  if (user) {
    setupRecipes([]);

    // Fetch data only when user is authenticated
    try {
      querySnapshot = await getDocs(collection(db, "Recipes"));

      console.log("Fetched recipes:", querySnapshot.docs.map((doc) => doc.data()));

      setupUI(user);

      // Pass the fetched data to your function
      setupRecipes(querySnapshot);
    } catch (error) {
      console.error('Error fetching documents:', error);

      alert("Failed to load recipes.");

      return;
    }
  } else {
    // User is not authenticated

    querySnapshot = [];

    setupUI();

    setupRecipes(querySnapshot);

    console.log('User is logged out');

    recipeList.innerHTML = 'Login to view recipes';

    return;
  }
});