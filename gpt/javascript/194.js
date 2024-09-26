
   import { getDatabase, ref, query, orderByChild, equalTo, onValue } from 'firebase/database';

   const database = getDatabase();
   const ref = ref(database, 'business');

   const q = query(ref, orderByChild('city'), equalTo('Pétion-Ville'));

   onValue(q, (snapshot) => {
     snapshot.forEach((childSnapshot) => {
       console.log(childSnapshot.key);
     });
   }, {
     onlyOnce: true
   });
   
