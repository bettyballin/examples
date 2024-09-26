<?php

function encrypt($plaintext, $key) {
    // Generate a random IV
    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-gcm'));

    // Encryption
    $encrypted = openssl_encrypt($plaintext, 'aes-256-gcm', $key, OPENSSL_RAW_DATA, $iv);

    return base64_encode("$iv:$encrypted");
}

function decrypt($ciphertext, $key) {
    // Decode the cipher text
    list($iv, $encryptedData) = explode(':', base64_decode($ciphertext), 2);

    return openssl_decrypt($encryptedData, 'aes-256-gcm', $key, OPENSSL_RAW_DATA, $iv);
}

// Test the functions
$key = 'your_secret_key_here';
$plaintext = 'Hello, World!';
$ciphertext = encrypt($plaintext, $key);
echo "Encrypted: $ciphertext\n";
$decrypted = decrypt($ciphertext, $key);
echo "Decrypted: $decrypted\n";

?>