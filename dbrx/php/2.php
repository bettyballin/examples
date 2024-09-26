<?php

function encryptField($data, $key) {
    // Generate an initialization vector
    $iv = random_bytes(openssl_cipher_iv_length('aes-256-cbc'));

    // Encrypt the data using OpenSSL library
    $encryptedData = openssl_encrypt(
        $data, 
        'AES-256-CBC', 
        hash('sha256', $key, true), 
        OPENSSL_RAW_DATA, 
        $iv
    );

    return base64_encode($iv . $encryptedData);
}

function decryptField($encodedData, $key) {
    // Decode the encoded data from Base64 format
    $decodedData = base64_decode($encodedData);

    // Extract IV and encrypted data parts
    $ivLength = openssl_cipher_iv_length('aes-256-cbc');
    $iv = substr($decodedData, 0, $ivLength);
    $encryptedData = substr($decodedData, $ivLength);

    return openssl_decrypt(
        $encryptedData, 
        'AES-256-CBC', 
        hash('sha256', $key, true), 
        OPENSSL_RAW_DATA, 
        $iv
    );
}

// Test the functions
$key = 'your_secret_key';
$data = 'Hello, World!';

$encrypted = encryptField($data, $key);
echo "Encrypted: $encrypted\n";

$decrypted = decryptField($encrypted, $key);
echo "Decrypted: $decrypted\n";

?>