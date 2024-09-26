firebase.firestore().collection('projects').where("visible", "==", true).onSnapshot(snap => {
  console.log('snap:', snap);
}, err => {
  console.error(err);
});