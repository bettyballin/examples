(async () => {
  await auth().signInAnonymously()
  let ref = firebase.firestore().collection("users");
  let user = await ref.doc(auth().currentUser.uid).get()
  console.log(user.data())
})();