<?php

$originalString = "Hello, World!";
$key = random_bytes(32); // Generate a 256-bit key using secure method.
$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc')); // Generate an IV.

// Encrypt the original string with AES-256-CBC and base64_encode it for readability.
$encryptedString = base64_encode(
    openssl_encrypt($originalString, 'aes-256-cbc', $key, OPENSSL_RAW_DATA, $iv)
);

echo "Encrypted String: <br>";
var_dump($encryptedString);
file_put_contents('encrypt.txt', json_encode([
    'data' => $encryptedString,
    'key' => base64_encode($key),
    'iv' => base64_encode($iv)
]));

?>