
const { randomBytes } = require('crypto');

function generateSecureToken(length, callback) {
  randomBytes(length, (err, buffer) => {
    if (err) {
      callback(err);
    } else {
      // Convert to base64 and replace URL-sensitive characters with their base64url counterparts
      let token = buffer.toString('base64').replace(/\+/g, '-').replace(/\//g, '_').replace(/=/g, '');
      callback(null, token);
    }
  });
}

// Usage
generateSecureToken(48, (err, token) => {
  if (err) {
    console.error('Error generating the token', err);
  } else {
    console.log('Secure token:', token);
  }
});

