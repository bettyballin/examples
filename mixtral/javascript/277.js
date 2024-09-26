(async () => {
  const user = { uid: 'some_uid' }; // Replace with actual user object
  const db = firebase.database(); // Assuming Firebase Realtime Database

  try {
    const ref = db.ref('/users/' + user.uid);
    await ref.update({ email: 'test@test.com' });
    console.log('Update successful');
  } catch (error) {
    console.error('Error updating user:', error);
  }
})();