
// Encryption
function encrypt($plaintext, $key, $iv) {
    return openssl_encrypt($plaintext, 'aes-256-cbc', $key, OPENSSL_RAW_DATA, $iv);
}

// Decryption
function decrypt($encrypted, $key, $iv) {
    return openssl_decrypt($encrypted, 'aes-256-cbc', $key, OPENSSL_RAW_DATA, $iv);
}

// Usage
$key = 'your-256-bit-secret-key'; // Make sure to use the correct key and iv
$iv = 'your-16-byte-iv';         // IV should be exactly 16 bytes for aes-256-cbc

$originalString = 'fwf2';
$encrypted
