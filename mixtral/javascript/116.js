const crypto = require('crypto');

function encrypt(txt, cryptkey) {
  const iv = Buffer.from(cryptkey).slice(0, 16); 

  let cipher = crypto.createCipheriv("aes-256-cbc", cryptkey, iv);

  let encryptedData = cipher.update(txt, 'utf8', 'hex');

  encryptedData += cipher.final('hex')

  return {
    data: encryptedData,
    iv: iv.toString('hex')
  };
}

let result = encrypt("1", "01234567890123456789012345678901");
console.log(result);