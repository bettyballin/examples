const crypto = require('crypto');
const base58 = require('bs58');

function sha256Base58(str) {
  const hashHex = crypto.createHash('sha256')
    .update(str)
    .digest('hex');
  return base58.encode(Buffer.from(hashHex, 'hex'));
}

console.log(
  sha256Base58(
    `One piece of chocolate cake one icecream cone one pickle one slice of swiss cheese one slice of salami one lollypop one piece of cherry pie one sausage one cupcake and one slice of watermelon`
  )
);