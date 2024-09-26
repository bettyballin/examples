const crypto = require('crypto');

crypto.randomBytes(48, function(err, buffer) {
  if (err) {
    console.error(err);
  } else {
    var token = buffer.toString('hex');
    console.log(token);
  }
});