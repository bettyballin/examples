<?php

$key = 'your_secure_key';
$data = 'your_data_to_encrypt';

$iv  = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));

// Encrypt
$encryptedData = openssl_encrypt($data, 'AES-256-CBC', $key, 0, $iv);

// Store the Initialization Vector (IV) along with encrypted data
$storedData = base64_encode($iv . $encryptedData);

print($storedData);

?>