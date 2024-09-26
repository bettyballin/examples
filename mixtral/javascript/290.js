const crypto = require('crypto');

let guess = 'your_guess_here'; // replace with your guess
let encryption = 'your_encrypted_data_here'; // replace with your encrypted data

try {
  const key = crypto.createDecipher('aes-256-cbc', guess);

  let decryptedData = '';

  // Decrypt data
  decryptedData += key.update(encryption, 'hex', 'utf8');

  // Finalize the process
  decryptedData += key.final('utf8');

  if (decryptedData === 'cheerio') {
    console.log("Correct password!");
  } else {
    throw new Error();
  }
} catch(err) {
  // Handle error
  console.error(`Incorrect guess: ${guess}`);
}