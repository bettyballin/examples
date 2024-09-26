const bs58check = require('bs58check');

function isValidDogecoinAddress(address) {
  try {
    const buffer = bs58check.decode(address);

    // Check the version byte (first byte of the decoded address).
    if (buffer[0] !== 30 || buffer[20] > 79) return false;

    // Calculate SHA-256 twice and compare with checksum.
    const hash = bs58check.hash(bs58check.hash(buffer.slice(0, 21)));

    for (let i = 0; i < 4 && buffer[i + 21] === hash[3 - i]; ++i);

    return i === 4;

  } catch {
    // If the address is not a valid Base58 string it's invalid.
    return false;
  }
}

// Usage:
const dogecoinAddress = 'DG2mPCnCPXzvRJcPx3FeZ9YnLbFUjhNBKd';
console.log(isValidDogecoinAddress(dogecoinAddress)); // true or false