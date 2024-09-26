const crypto = require('crypto');

const message = 'Hello world!';
const secret = 'my_secret_key';
const generatedSignature = crypto.createHmac('sha256', secret).update(message).digest();
const givenSignature = '3fn0mhrebHTJMhtOyvRP5nZIhogX/M1OKQ5GojniZTM=';

// Encode both signatures using the same method
const encodedGeneratedSignature = Buffer.from(generatedSignature).toString('binary');
const encodedGivenSignature = Buffer.from(givenSignature, 'base64').toString('binary');

// Compare the two signatures byte by byte
for (let i = 0; i < encodedGeneratedSignature.length; i++) {
  if (encodedGeneratedSignature[i] !== encodedGivenSignature[i]) {
    console.log('Signatures do not match');
    process.exit(1);
  }
}
console.log('Signatures match');