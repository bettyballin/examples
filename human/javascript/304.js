const crypto = require('crypto');

class AES {
  static encrypt(data) {
    const iv = crypto.randomBytes(16);
    const key = crypto.randomBytes(32);
    const cipher = crypto.createCipheriv('aes-256-cbc', key, iv);
    let encrypted = cipher.update(data, 'utf8', 'hex');
    encrypted += cipher.final('hex');
    return iv.toString('hex') + ':' + encrypted;
  }

  static decrypt(data) {
    const parts = data.split(':');
    const iv = Buffer.from(parts.shift(), 'hex');
    const encrypted = parts.join(':');
    const key = crypto.randomBytes(32);
    const decipher = crypto.createDecipheriv('aes-256-cbc', key, iv);
    let decrypted = decipher.update(encrypted, 'hex', 'utf8');
    decrypted += decipher.final('utf8');
    return decrypted;
  }
}

var data = {
  name: 'Catalin',
  surname: 'Munteanu',
  address: 'Romania'
};

// Encryption
var encrypted_data = AES.encrypt(JSON.stringify(data));
console.log(`Encrypted Data: ${encrypted_data}`);

// Decryption
try {
  var decrypted_data = JSON.parse(AES.decrypt(encrypted_data));
  console.log(`Decrypted Data: ${JSON.stringify(decrypted_data)}`);
} catch (e) {
  console.log(`Error: ${e}`);
}