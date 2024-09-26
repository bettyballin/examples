const crypto = require('crypto');

function hashPassword(pwd, fn) {
  var hash = crypto.createHash('sha256').update(pwd).digest('base64');
  fn(null, hash);
}

// Test the function
hashPassword('mysecretpassword', (err, hash) => {
  if (err) throw err;
  console.log(hash);
});