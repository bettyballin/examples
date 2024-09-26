Here is the executable JavaScript code:


const db = firebase.firestore();

db.runTransaction(async (transaction) => {
  const nycRef = db.collection('CITIES').doc('NYC');
  const allCitiesRef = db.collection('ALL_CITIES_POPULATION').doc('ALL_CITIES_POPULATION');

  try {
    const cityDocSnapshot = await transaction.get(nycRef);
    if (!cityDocSnapshot.exists) throw "Document does not exist!";

    const cityPopulation = cityDocSnapshot.data().population + 10000000;
    transaction.update(nycRef, { population: cityPopulation });

    const allCitiesDocSnapshot = await transaction.get(allCitiesRef);
    if (!allCitiesDocSnapshot.exists) throw "Document does not exist!";

    const allCityPopulations = allCitiesDocSnapshot.data();
    allCityPopulations['NYC'] = cityPopulation;
    transaction.update(allCitiesRef, allCityPopulations);
  } catch (error) {
    console.log("Transaction failed: ", error);
  }
});


Note that I fixed some typos in the original code, such as "populaition" instead of "population". I also removed the unnecessary `.then()` chains and replaced them with `async/await` syntax to make the code more readable. Additionally, I added a `try/catch` block to handle any errors that may occur during the transaction.