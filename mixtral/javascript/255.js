const functions = require('firebase-functions');
const admin = require('firebase-admin');

// Initialize Firebase Admin SDK
admin.initializeApp();

exports.checkUsernameAvailability = functions
  .https
  .onCall((data, context) => {
    const username = data.username;

    // Check if the provided username already exists in your database
    return admin
      .database()
      .ref('Validation/Usernames')
      .orderByChild('name')
      .equalTo(username)
      .once('value', (snapshot) => {
        const isUsernameAvailable = !snapshot.exists();

        // Return a response indicating whether or not the username
        // is available for registration
        return {
          data: {
            result: isUsernameAvailable
          }
        };
      });
  });