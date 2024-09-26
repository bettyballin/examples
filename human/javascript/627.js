const crypto = require('crypto');

const stringToSign = "Test";
const secretAccessKey = "bAvW5O18eSrxke4I7eFcrnrDJkN+wKQmx9aSHuMZQ0w=";

const secretAccessKeyBase64 = Buffer.from(secretAccessKey, 'base64');
const keyBytes = secretAccessKeyBase64;
const stringToSignBytes = Buffer.from(stringToSign, 'utf-8');

const hmac = crypto.createHmac('sha256', keyBytes);
hmac.update(stringToSignBytes);
const signatureHash = hmac.digest();
const signature = signatureHash.toString('base64');
console.log(signature);