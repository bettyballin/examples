const crypto = require('crypto');
const base58 = require('bs58');

function validateDogecoinAddress(address) {
  const decodedBase58Result = base58.decode(address);
  if (decodedBase58Result.length !== 25) return false;

  // Extract the version and checksum from the Base58-decoded result
  const addressVersion = decodedBase58Result.slice(0, 1).toString('hex');
  const expectedChecksum = decodedBase58Result.slice(-4);

  // Calculate double SHA-256 hash of the first part (version + public key)
  let sha256Hasher = crypto.createHash('sha256').update(decodedBase58Result.slice(0, 21));
  let hash = sha256Hasher.digest();
  sha256Hasher = crypto.createHash('sha256').update(hash);
  let checksum = Buffer.from(sha256Hasher.digest()).slice(0, 4);
  
  return addressVersion === '1e' && expectedChecksum.equals(checksum);
}

// Test the function
const testAddress = 'DQbJ7j6aXNnZ3xKqf9yv5rYzgU8GtWdPpM';
console.log(validateDogecoinAddress(testAddress)); // true or false