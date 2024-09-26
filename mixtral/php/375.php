<?php

$key = base64_decode('your_secret_base64_encoded_key');

// Encryption
$cipher = "AES-128-CBC";
$ivlen  = openssl_cipher_iv_length($cipher);
$iv     = openssl_random_pseudo_bytes($ivlen);

$data = 'your secret data';
$encryptedData = base64_encode(openssl_encrypt($data, $cipher, $key, OPENSSL_RAW_DATA, $iv) . '::' . $iv);

// Decryption
list ($encrypted, $iv) = explode("::", base64_decode($encryptedData), 2);
$decryptedData    = openssl_decrypt($encrypted, $cipher, $key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING, $iv);

echo "Encrypted Data: $encryptedData\n";
echo "Decrypted Data: $decryptedData\n";

?>