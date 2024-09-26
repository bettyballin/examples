const EthCrypto = require('eth-crypto');

const message = "Hello, World!";
const signature = "0x...your_signature_here...";

const address2 = EthCrypto.recover(
  signature,
  EthCrypto.hash.keccak256(
    `\x19Ethereum Signed Message:\n${message.length}${message}`
  )
);

console.log(address2);