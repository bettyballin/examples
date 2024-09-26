<?php

function encrypt($data) {
    $secretKey = 'your-secret-key';
    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));
    return base64_encode(
        $iv .
        openssl_encrypt($data, 'aes-256-cbc', $secretKey, 0, $iv)
    );
}

function decrypt($encryptedData) {
    $secretKey = 'your-secret-key';
    $decodedData = base64_decode($encryptedData);
    $ivLength = openssl_cipher_iv_length('aes-256-cbc');
    $iv = substr($decodedData, 0, $ivLength);
    $encryptedMessage = substr($decodedData, $ivLength);
    return openssl_decrypt(
        $encryptedMessage,
        'aes-256-cbc',
        $secretKey,
        OPENSSL_RAW_DATA,
        $iv
    );
}

// Test the functions
$data = 'Hello, World!';
$encrypted = encrypt($data);
echo "Encrypted: $encrypted\n";
$decrypted = decrypt($encrypted);
echo "Decrypted: $decrypted\n";

?>