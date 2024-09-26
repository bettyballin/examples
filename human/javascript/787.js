firebase.firestore().collection('projects').where("visible", "==", true).onSnapshot(querySnapshot => {
  querySnapshot.forEach(doc => {
    console.log(doc.data());
  });
});