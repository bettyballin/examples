
<?php
// Generate a strong encryption key
$key = openssl_random_pseudo_bytes(32);

// Your sensitive data
$password = 'my_secret_password';

// Encrypt the data
$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256
