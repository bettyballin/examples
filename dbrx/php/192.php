<?php

function encrypt($data, $key)
{
    // Remove the base64 encoding from our key
    $encryption_key = base64_decode($key);

    // Generate an initialization vector
    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));

    // Encrypt the data using AES 256 encryption in CBC mode using our encryption key and initialization vector.
    $encrypted = openssl_encrypt($data, 'aes-256-cbc', $encryption_key, 0, $iv);

    // The $iv is just as important as the key for decrypting so save it with our encrypted data using a unique separator (::)
    return base64_encode($encrypted . '::' . $iv);
}

// Test the function
$key = base64_encode('your_secret_key_here');
$data = 'Hello, World!';
echo encrypt($data, $key);

?>