const crypto = require('crypto');
const dataToHash = 'your_data_to_hash'; // replace with your data

const hmac = crypto.createHmac('sha256', dataToHash);
hmac.update(dataToHash);

// Convert the hash into a Buffer
let bufferKey = Buffer.from(hmac.digest('binary'));

// Create Uint8Array from ArrayBuffer
const key = new Uint8Array(bufferKey).slice(0, 32);

console.log(key);