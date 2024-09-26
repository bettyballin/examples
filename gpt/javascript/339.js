
firebase.firestore().collection('projects').onSnapshot(snap => {
  console.log('snap:', snap);
}, err => {
  console.error(err);
});

