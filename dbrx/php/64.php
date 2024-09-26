<?php

// Set data and encryption key
$data = 'Hello, World!';
$encryption_key = 'your_secret_key_here'; // Replace with your own secret key

// Generate a random initialization vector (IV)
$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));

// Encrypt data with AES-256-CBC algorithm and base64_encode for easier storage/transfer
$data_encrypted_base64 = base64_encode(
    $iv . 
    openssl_encrypt($data, 'AES-256-CBC', $encryption_key, OPENSSL_RAW_DATA, $iv)
);

// Store the encrypted data in your database
$db_encrypted_data = $data_encrypted_base64;

// When retrieving from DB:
$decrypted_data = openssl_decrypt(
    substr(base64_decode($db_encrypted_data), 16),
    'AES-256-CBC',
    $encryption_key,
    OPENSSL_RAW_DATA,
    substr(base64_decode($db_encrypted_data), 0, 16)
);

echo "Encrypted Data: $data_encrypted_base64\n";
echo "Decrypted Data: $decrypted_data\n";

?>