<?php

function importAESGCMKeyFromPassword($password, $salt) {
    $key = openssl_pbkdf2($password, $salt, 32, 1000, 'sha256');
    return $key;
}

function decryptAESGCM($key, $iv, $message) {
    $decrypted = openssl_decrypt(base64_decode($message), 'aes-256-gcm', $key, OPENSSL_RAW_DATA, base64_decode($iv));
    return $decrypted;
}

$password = 'your_password';
$salt = 'your_salt';
$message = 'your_base64_encoded_message';
$iv = 'your_base64_encoded_iv';

$key = importAESGCMKeyFromPassword($password, $salt);
$decrypted = decryptAESGCM($key, $iv, $message);

echo $decrypted;

?>