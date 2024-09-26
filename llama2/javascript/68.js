let userId = 'some-user-id';
let messageRef = firebase.database().ref('messages');

messageRef.orderByChild(`readBy/${userId}`).equalTo(false).on("child_added", (snapshot) => {
  console.log("Unread messages = " + snapshot.numChildren());

  // Add the indexOn dynamically
  snapshot.ref.update({
    'readBy': {
      [userId]: true
    }
  });
});