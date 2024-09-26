import firebase from 'firebase/app';
import 'firebase/firestore';

// Initialize Firebase
firebase.initializeApp({
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  projectId: '<PROJECT_ID>',
});

const db = firebase.firestore();

async function batchedWrites() {
  const batch = db.batch();

  // Create a new document in 'batched_writes' with unique ID and transaction details.
  const docRef1 = await db.collection('batched_writes').add({
    collection: 'CITIES',
    id: 'NYC',
    operation: 'update',
    data: { population: 10000000 },
  });

  // Create a new document in 'batched_writes' with unique ID and transaction details.
  const docRef2 = await db.collection('batched_writes').add({
    collection: 'ALL_CITIES_POPULATION',
    id: 'ALL_CITIES_POPULATION',
    operation: 'update',
    data: { NYC: 1000000 },
  });

  try {
    // Perform the actual Firestore update operations within a transaction.
    await db.runTransaction(async (transaction) => {
      const nycDoc = await transaction.get(db.collection('CITIES').doc('NYC'));
      if (!nycDoc.exists) throw 'Document does not exist!';

      // Update NYC population in CITIES collection
      transaction.update(nycDoc.ref, { population: docRef1.get('data.population') });

      const allCitiesPopulationDoc = await transaction.get(
        db.collection('ALL_CITIES_POPULATION').doc('ALL_CITIES_POPULATION')
      );
      if (!allCitiesPopulationDoc.exists) throw 'Document does not exist!';

      // Update NYC property in ALL_CITIES_POPULATION collection
      transaction.update(allCitiesPopulationDoc.ref, {
        [docRef1.get('collection')]: docRef2.get('data'),
      });

      return true;
    });
    console.log('Transaction successfully committed!');
  } catch (error) {
    console.error('Transaction failed:', error);
  }
}

batchedWrites();