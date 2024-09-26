<?php

$key = random_bytes(32); // 256-bit encryption key
$iv = random_bytes(16); // 16-byte initialization vector (IV)
$data = 'Hello, World!'; // data to be encrypted

$ciphertext = openssl_encrypt($data, 'aes-256-cbc', $key, OPENSSL_RAW_DATA, $iv);

print($ciphertext);

?>