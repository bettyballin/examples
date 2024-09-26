// Set custom claims for the current user with their Firebase Auth UID and email address.
firebase.auth().currentUser.getIdToken(true).then((idToken) => {
  return fetch('https://your-project-id.cloudfunctions.net/setCustomClaims', {
    method: 'POST',
    headers: new Headers({
      Authorization: `Bearer ${idToken}`,
      'Content-Type': 'application/json'
    }),
    body: JSON.stringify({
      uid: firebase.auth().currentUser.uid,
      email: firebase.auth().currentUser.email
    })
  });
}).catch((error) => {
  console.error(error);
});