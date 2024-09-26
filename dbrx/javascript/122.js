This is not JavaScript code, but rather a Cloud Firestore security rule written in a specific syntax. However, I will provide the equivalent JavaScript code for a Cloud Function that achieves the same functionality:


const admin = require('firebase-admin');
admin.initializeApp();

const db = admin.firestore();

exports.authorizeRead = async (req, res) => {
  const userId = req.auth.uid;
  const documentPath = req.path;

  if (!documentPath.startsWith(`users/${userId}/`)) {
    res.status(403).send('Access denied');
    return;
  }

  const userDocRef = db.doc(`users/${userId}`);
  const userDoc = await userDocRef.get();

  if (!userDoc.exists) {
    res.status(404).send('User document not found');
    return;
  }

  res.status(200).send('Access granted');
};