const crypto = require('crypto');

const decrypt = (text, secretKey, iv = null) => {
  const decipher = crypto.createDecipheriv('des-ede3-cfb8', secretKey, iv);
  let decrypted = decipher.update(text, '', 'utf8'); 
  decrypted += decipher.final('utf8');
  return decrypted;
}

const name = "OrjgCsq9EkT2TkCZzDOfW492nXQCNIC0BtVJy1FaaTXv2jXAPqx75kaUJVSG/5MCFXXq"
const decoded = Buffer.from(name, 'base64')
const decodedShorter = decoded.slice(0, decoded.length - 8)
const iv = decoded.slice(decoded.length - 8)
const key = Buffer.from('ffa3b5205582d6ea7de6439ec2bafef46a80810003158922', 'hex');
console.log(decrypt(decodedShorter, key, iv))