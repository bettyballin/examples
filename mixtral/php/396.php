<?php

function encrypt($plaintext, $key) {
    $iv = 'aaaaaaaaaaaaaaaa';

    $ciphertext = openssl_encrypt(
        $plaintext,
        "AES-256-CBC",
        $key,
        OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING,
        $iv
    );

    return base64_encode($ciphertext);
}

// Example usage:
$key = 'your_secret_key_here';
$plaintext = 'Hello, World!';
echo encrypt($plaintext, $key);

?>