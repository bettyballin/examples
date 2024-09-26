<?php
$key = '_My-16-byte-key_';
$plaintext = 'The rooster crows at midnight!';
$ciphertext = openssl_encrypt($plaintext, 'aes-128-ecb', $key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING);

echo bin2hex($ciphertext);
?>