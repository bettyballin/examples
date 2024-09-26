
// Size of the IV for AES 256 CBC is 16 bytes (128 bits)
$ivLength = openssl_cipher_iv_length('aes-256-cbc');
$iv = openssl_random_pseudo_bytes($ivLength);

// Check if the IV is generated securely
if ($iv === false) {
    throw new Exception("Could not generate a secure IV.");
}

// Use $iv with the encryption function
// $encryptedData = openssl_encrypt($dataToEncrypt, 'aes-256-cbc', $encryptionKey, OPENSSL_RAW_DATA, $iv);

