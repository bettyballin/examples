const crypto = require('crypto');

function enc(a) {
  const keyIv = crypto.pbkdf2Sync("lrvq/wyDf6tqhxvg8NuIDQ==", "Ivan Medvedev", 1000, 48, 'sha1');
  const key = keyIv.slice(0, 32);
  const iv = keyIv.slice(32);
  const data = Buffer.from(a, 'utf16le');

  const cipher = crypto.createCipheriv('aes-256-cbc', key, iv);
  const encrypted = Buffer.concat([cipher.update(data), cipher.final()]);

  return encrypted.toString('base64');
}

console.log(enc("Cat")); // CZ/1nUYEjhw4cFj08Yt1EQ==