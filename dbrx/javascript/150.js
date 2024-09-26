const { Hmac } = require('@microsoft/msrcrypto');
const crypto = require('crypto');

// Replace 'storageaccountaccesskeyfromAzureViaEnvironmentVariable' and strToSign accordingly.
let secretKey = Buffer.from("storageaccountaccesskeyfromAzureViaEnvironmentVariable", "base64");
let strToSign = "your_string_to_sign";
let data = Buffer.from(strToSign);

const hmac = new Hmac(crypto.createHash('sha256'), secretKey);
hmac.update(data);
const hashInBase64 = hmac.digest().toString('base64');

console.log(hashInBase64); // Output: <your_base_64_hash>