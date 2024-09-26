
const crypto = require('crypto');

// Your storage account access key from Azure via environment variable
const storageAccountAccessKey = process.env.AZURE_STORAGE_ACCESS_KEY;

// Convert the base64-encoded secret to a buffer
const secret = Buffer.from(storageAccountAccessKey, 'base64');

// Create a string to sign
const strToSign = '...'; // This should be the string you want to sign

// Create the HMAC hash
const hash = crypto.createHmac('sha256', secret)
                   .update(strToSign)
                   .digest();

// Convert the hash to a base64-encoded string
const hashInBase64 = hash.toString('base64');

// This is the string you would use for the Authorization header
console.log(hashInBase64);

