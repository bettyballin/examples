const crypto = require('crypto');

// Parse Azure storage account access key
let secretKey = Buffer.from(process.env.AZURE_STORAGE_ACCESS_KEY, 'base64').toString();

// Set the string to sign
let strToSign = "your_string_to_sign";

// Generate HMAC SHA256 hash
let hmac = crypto.createHmac('sha256', secretKey);
hmac.update(strToSign, 'utf-8');

// Convert the generated hash into Base64 format
let authToken = Buffer.from(hmac.digest()).toString('base64');

console.log(authToken);