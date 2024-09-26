
<?php
// Encryption and decryption keys should be kept secret and stored securely.
// They should not be hardcoded in your script in production.
define('ENCRYPTION_KEY', 'your-secret-encryption-key');

function encryptCreditCardNumber($creditCardNumber, $key) {
    $ivlen = openssl_cipher_iv_length($cipher="AES-128-CBC");
    $iv = openssl_random_pseudo_bytes($ivlen);
    $ciphertext_raw = openssl_encrypt($creditCardNumber, $cipher, $key, $options=OPENSSL_RAW_DATA, $iv);
    $hmac = hash_hmac('sha256', $ciphertext_raw, $key, $as_binary=true);
    $ciphertext = base64_encode(
