
// This is for Firestore
firebase.firestore().collection('users').doc(userId.toString()).set({
  username: name,
  email: email,
  profile_picture: imageUrl
