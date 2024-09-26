<?php

// Encrypt
function encrypt($data, $key) {
    // Generate initialization vector
    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));

    // Use OpenSSL to encrypt the data
    $encryptedData = openssl_encrypt($data, 'aes-256-cbc', $key, 0, $iv);

    return base64_encode("$iv:$encryptedData");
}

// Decrypt
function decrypt($encodedData, $key) {
    // Split the encoded data into initialization vector and encrypted data
    list($iv, $data) = explode(':', base64_decode($encodedData), 2);

    return openssl_decrypt($data, 'aes-256-cbc', $key, 0, $iv);
}

// Usage
$originalString = "hello world!";
$saltOrKey = "ABCD1234";

echo encrypt($originalString, $saltOrKey) . "\n";

$encryptedData = encrypt($originalString, $saltOrKey); // Encoded data from the previous step

echo decrypt($encryptedData, $saltOrKey);

?>