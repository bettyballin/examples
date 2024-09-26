const jwt = require('jsonwebtoken');

// Public Key
let pubKey = '-----BEGIN PUBLIC KEY-----\
' +
    'YOUR_PUBLIC_KEY_HERE\
' +
    '-----END PUBLIC KEY-----';

let token = 'YOUR_TOKEN_HERE';

try {
  let decodedToken = jwt.verify(token, pubKey);

  console.log('Valid Token:', decodedToken);
  // If token is valid then it will return the payload
} catch (err) {

  console.log('Invalid Token:', err);

}