const admin = require('firebase-admin');
const functions = require('firebase-functions');

admin.initializeApp();

exports.onFollow = functions.https.onRequest((req, res) => {
  const currentUserUid = req.query.currentUserId;
  const targetUserUid = req.query.targetUserId;

  // Add the user being followed to the "following" node of the current user
  admin
    .database()
    .ref(`/users/${currentUserUid}/following`)
    .child(targetUserUid)
    .set({
      timestamp: Date.now(),
    });

  // Add an object with the current user's uid to the "followers" node of the target user
  admin
    .database()
    .ref(`/users/${targetUserUid}/followers`)
    .child(currentUserUid)
    .set({
      timestamp: Date.now(),
    });

  res.send('Followed successfully');
});

exports.onUnfollow = functions.https.onRequest((req, res) => {
  const currentUserUid = req.query.currentUserId;
  const targetUserUid = req.query.targetUserId;

  // Remove the user being unfollowed from the "following" node of the current user
  admin
    .database()
    .ref(`/users/${currentUserUid}/following`)
    .child(targetUserUid)
    .remove();

  // Remove an object with the current user's uid to the "followers" node of the target user
  admin
    .database()
    .ref(`/users/${targetUserUid}/followers`)
    .child(currentUserUid)
    .remove();

  res.send('Unfollowed successfully');
});