<?php

// Include sodium library
require_once 'vendor/autoload.php';

use Sodium;

// Generate a random key (32 bytes)
$key = Sodium::randombytes_buf(Sodium::CRYPTO_SECRETKEYBYTES);

// Encrypt data using AES-GCM mode with the generated key and an empty nonce.
$data = "This is some secret data.";
$nonce = '';
$ciphertext = sodium_crypto_aead_aes256gcm_encrypt($data, $nonce, $key);
echo 'Encrypted: ' . bin2hex($ciphertext) . PHP_EOL;

// Decrypt ciphertext using AES-GCM mode with the same key and nonce.
$decrypted_data = sodium_crypto_aead_aes256gcm_decrypt($ciphertext, $nonce, $key);

if ($decrypted_data === false) {
    echo 'Decryption failed' . PHP_EOL;
} else {
    echo 'Decrypted: ' . $decrypted_data . PHP_EOL;
}

?>