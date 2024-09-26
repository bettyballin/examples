const crypto = require('crypto');

const ciphertext = 'OrjgCsq9EkT2TkCZzDOfW492nXQCNIC0BtVJy1FaaTXv2jXAPqx75kaUJVSG/5MCFXXq';
const key = Buffer.from('ffa3b5205582d6ea7de6439ec2bafef46a80810003158922', 'hex');

const decipher = crypto.createDecipheriv('aes-256-ecb', key, '');
decipher.setAutoPadding(false);

const decrypted = Buffer.concat([decipher.update(ciphertext, 'base64'), decipher.final()]);

console.log(decrypted.toString());