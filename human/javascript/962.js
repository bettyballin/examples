db.collection("users").get().then(res => {
  const user = res.docs.find(user => user.data().uid === auth.currentUser.uid);
  console.log(user);
});