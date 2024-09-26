(async () => {
  let jwtToken = await firebase.auth().currentUser.getIdToken();
  console.log(jwtToken);
})();