db.collection('chatRooms').doc(roomId).collection('msgs')
  .where('participants', 'array-contains', firebase.auth().currentUser.uid)
  .get()
  .then(querySnapshot => {
    querySnapshot.forEach(doc => {
      console.log(doc.data());
    });
  })
  .catch(error => {
    console.error(error);
  });