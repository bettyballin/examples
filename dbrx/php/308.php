<?php

function generateKeyFromPassword($password) {
    // Use PBKDF2 for key derivation from password.
    $iterations = 10000;
    $salt = random_bytes(16);
    return hash_pbkdf2('sha256', $password, $salt, $iterations, 32, true);
}

function generateIv() {
    // Generate a unique IV per encryption operation.
    return random_bytes(openssl_cipher_iv_length('aes-256-cbc'));
}

$password = 'your_password_here';
$key = generateKeyFromPassword($password);
$iv = generateIv();

$dataToEncrypt = 'Your data here';

$cipherTextRaw = openssl_encrypt(
    $dataToEncrypt,
    'AES-256-CBC',
    $key,
    OPENSSL_RAW_DATA,
    $iv
);

if ($cipherTextRaw === false) {
    throw new Exception(openssl_error_string());
}

print($cipherTextRaw);

?>