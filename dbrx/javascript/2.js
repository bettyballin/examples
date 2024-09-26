const express = require('express');
const crypto = require('crypto');

const app = express();

app.get('/test', function(req, res) {
  var key = '12345678901234567890123456789012';
  var iv = Buffer.from('123456789012'); // convert string IV into buffer

  var cipher = crypto.createCipheriv('aes-256-gcm', key, iv);
  var aad = Buffer.from(''); // additional authenticated data (AAD)
  cipher.setAAD(aad);

  var encryptedData = cipher.update(Buffer.from('bla'));
  var authTag = cipher.final();
  console.log(encryptedData.toString('hex'));
  console.log(authTag.toString('hex'));

  var decipher = crypto.createDecipheriv('aes-256-gcm', key, iv);
  decipher.setAuthTag(authTag); // set the authentication tag
  decipher.setAAD(aad);

  try {
    const decryptedData = Buffer.concat([
      decipher.update(encryptedData),
      decipher.final()
    ]);
    console.log(decryptedData.toString());
  } catch (error) {
    console.error('Decryption failed:', error);
  }
  res.send('Test completed');
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});