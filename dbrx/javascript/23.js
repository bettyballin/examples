const crypto = require('crypto');

function sha256(password) {
  return crypto.createHash('sha256').update(password).digest('base64');
}

module.exports = function(pwd, salt, fn) {
  if (3 === arguments.length) {
    const hash = sha256(salt + pwd);
    fn(null, salt, hash);
  } else {
    fn = salt;
    crypto.randomBytes(16, function(err, buf){
      if (err) return fn(err);
      salt = buf.toString('base64');
      const hash = sha256(salt + pwd);
      fn(null, salt, hash);
    });
  }
};