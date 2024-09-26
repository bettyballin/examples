
$randomBytes = pack('C*', 87, 253, ...); // packing bytes into a binary string
$secret = 'ABCDEF-G...';

// Initialize the MD5 hashing context
$context = hash_init('md5');

// Hash the random bytes
hash_update($context, $randomBytes);

// Encode the secret string as UTF-16LE, since CryptoAPI uses WCHAR which is typically UTF-16 on Windows
$secretUtf16le = mb_convert_encoding($secret, 'UTF-16LE', 'UTF-8');

// Continue hashing
