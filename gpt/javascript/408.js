
const crypto = require('crypto'); 
const encryptionKey = crypto.randomBytes(16); // 128-bit key
const IV = crypto.randomBytes(16); // Initialization vector

const data = "who let the dogs out";

var encrypt = ((dataValue) => {
  let cipher = crypto.createCipheriv('aes-128-gcm', encryptionKey, IV);
  let encrypted = cipher.update(dataValue, 'utf8', 'base64');
  encrypted += cipher.final('base64');
  return encrypted;
});

var decrypt = ((encrypted) => {
  let decipher = crypto.createDec
