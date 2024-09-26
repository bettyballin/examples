const rules = {
  "rules": {
    "users": {
      "$uid": {
        ".write": "auth.uid == $uid"
      }
    }
  }
};

// Assume you have the Firebase Realtime Database initialized
const db = firebase.database();

// Assume you have the Firebase Authentication initialized
const auth = firebase.auth();

// Define a function to validate the write access
function validateWriteAccess(uid) {
  return auth.currentUser.uid === uid;
}

// Use the function to validate the write access
db.ref("users").on("child_added", (snapshot) => {
  const uid = snapshot.key;
  if (validateWriteAccess(uid)) {
    console.log(`Write access granted for user ${uid}`);
  } else {
    console.log(`Write access denied for user ${uid}`);
  }
});