(async () => {
  const idToken = await firebase.auth().currentUser.getIdToken();
  console.log(idToken);
})();