firebase.firestore()
  .collection("invites")
  .where("user_email", "==", myUserEmail)
  .onSnapshot((snapshot) => {
    snapshot.docChanges().forEach(change => {
      if (change.type === "removed" && !change.doc.exists) return;

      console.log(change.doc.id, change.doc.data());
    });
  })