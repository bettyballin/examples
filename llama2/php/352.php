<?php

function encrypt_aes_gcm($key, $iv, $message)
{
    $cipher = 'aes-256-gcm';
    $tag = '';
    $encrypted_message = openssl_encrypt($message, $cipher, $key, OPENSSL_RAW_DATA, $iv, $tag, '');
    return array($encrypted_message, $tag);
}

// Example usage:
$key = openssl_random_pseudo_bytes(32);
$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-gcm'));
$message = 'Hello, World!';
$result = encrypt_aes_gcm($key, $iv, $message);
print_r($result);

?>