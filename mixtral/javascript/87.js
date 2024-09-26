const crypto = require('crypto');

function pbkdf2(secret, salt) {
  return new Promise((resolve, reject) => {
    const keylen = 64;

    crypto.pbkdf2(
      secret,
      salt,
      100000,
      keylen,
      'sha512',
      (err, derivedKey) => {
        if (err || !derivedKey) reject('Error generating hash');
        resolve(Buffer.from(derivedKey).toString('hex'));
      }
    );
  });
}

pbkdf2('password', 'salt')
  .then((hash) => console.log(`Hash: ${hash}`))
  .catch((err) => console.error(err));