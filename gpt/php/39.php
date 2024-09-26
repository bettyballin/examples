
<?php
// Your secret key (keep this safe!)
$secretKey = 'your-secret-key';

// The plaintext password you want to encrypt
$password = 'user-password';

// Encrypt the password
$ivlen = openssl_cipher_iv_length($cipher="AES-128-CBC");
$iv = openssl_random_pseudo_bytes($ivlen);
$ciphertext_raw = openssl_encrypt($password, $cipher, $secretKey, $options=OPENSSL_RAW_DATA, $iv);
$hmac = hash_hmac('sha256', $
