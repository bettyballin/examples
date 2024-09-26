
<?php

define('ENCRYPTION_KEY', 'your-256-bit-secret-key');
define('ENCRYPTION_IV', 'your-256-bit-secret-iv'); // Ensure this is exactly 16 bytes for AES-256

function AES256_encode($dataToEncrypt) {
    return openssl_encrypt(
        $dataToEncrypt,
        'aes-256-cbc',
        ENCRYPTION_KEY,
        0,
        ENCRYPTION_IV
    );
}

function AES256_decode($encryptedData) {
    return openssl_decrypt(
        $encryptedData,
        'aes-256-cbc',
        ENCRYPTION_KEY,
        0,
        ENCRYPTION_IV
    );
}

// Usage
$originalData = "My secret data";
$encryptedData = AES256_encode($originalData);
$decryptedData = AES256_decode($encryptedData);

echo "Encrypted: " . $encryptedData . "\n";
echo "Decrypted: " . $dec
