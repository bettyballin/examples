const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp();

exports.match = functions.https.onRequest((req, res) => {
  const user = req.params.user;
  const documents = req.params.documents;

  if (req.method === 'GET' || req.method === 'PUT') {
    if (req.auth && req.auth.uid === user) {
      res.status(200).send('Access granted');
    } else {
      res.status(403).send('Access denied');
    }
  } else {
    res.status(405).send('Method not allowed');
  }
});