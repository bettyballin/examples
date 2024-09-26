<?php

$key = 'your_secret_key';
$plaintext = 'Hello World!';

$cipher = 'aes-256-cbc';
$cipherText = openssl_encrypt($plaintext, $cipher, $key, 0, substr($key, 0, 16));

echo base64_encode($cipherText);

?>