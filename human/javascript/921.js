(async () => {
  const firebase = require('firebase/app');
  require('firebase/firestore');
  firebase.initializeApp({
    apiKey: '<API_KEY>',
    authDomain: '<AUTH_DOMAIN>',
    projectId: '<PROJECT_ID>',
  });
  const db = firebase.firestore();
  const snapshot = await db.collectionGroup("orders").get();
  console.log(snapshot.size, "docs");
})();