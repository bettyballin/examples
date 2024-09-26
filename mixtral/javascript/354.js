const solanaWeb3 = require('@solana/web3.js');

const wallet = new solanaWeb3.Keypair();
const secret = wallet.secretKey;
const encodedSecret = Buffer.from(secret).toString('base64');
console.log(`encoded private key... ${encodedSecret}`);
// Save the `encodedSecret` to your database or file

// To use it later you can decode and create a new keypair like this:

const decodedSecret = Uint8Array.from(Buffer.from(encodedSecret, 'base64'));
let wallet2 = solanaWeb3.Keypair.fromSecretKey(decodedSecret);
console.log(`public key... ${wallet2.publicKey}`);