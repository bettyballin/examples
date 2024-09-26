(async function() {
  const ref = firebase.database().ref();
  const state = 'your_state';
  const expireTime = Date.now() / 1000;

  return await ref.child(state).orderByChild('end').startAt(expireTime).once('value', (dataSnapshot) => {
    console.log(dataSnapshot.val());
  });
})();