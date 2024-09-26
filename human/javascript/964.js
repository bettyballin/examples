// No executable code can be generated for this rules definition.
// However, here is a representation of how you might implement this in a Node.js environment using Firebase:

const firebase = require('firebase/app');
const admin = require('firebase-admin');

admin.initializeApp({
  // Your Firebase project credentials
});

const db = admin.firestore();

const securityRules = async (req, res, next) => {
  const userId = req.params.userId;
  const userAuth = req.user;

  if (userAuth && userAuth.uid === userId) {
    next();
  } else {
    res.status(403).send('Forbidden');
  }
};

const readUser = async (req, res) => {
  const userId = req.params.userId;
  const userRef = db.collection('users').doc(userId);
  const doc = await userRef.get();

  if (!doc.exists) {
    res.status(404).send('User not found');
  } else {
    res.send(doc.data());
  }
};

const writeUser = async (req, res) => {
  const userId = req.params.userId;
  const userData = req.body;

  try {
    await db.collection('users').doc(userId).set(userData);
    res.send('User updated successfully');
  } catch (error) {
    res.status(500).send('Error updating user');
  }
};

const express = require('express');
const app = express();

app.get('/users/:userId', securityRules, readUser);
app.post('/users/:userId', securityRules, writeUser);