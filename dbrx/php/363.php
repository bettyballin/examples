<?php

use ParagonIE_Sodium_Compat;

function decodeBase64($data) {
    return base64_decode($data);
}

$key = 'your_secret_key_here'; // replace with your secret key
$nonce = 'your_nonce_here'; // replace with your nonce
$data = 'your_base64_encoded_data_here'; // replace with your base64 encoded data

$decodedData = base64_decode($data);
$decryptedData = ParagonIE_Sodium_Compat::crypto_secretbox_open(
    $decodedData,
    sodium_hex2bin($nonce),
    sodium_hex2bin($key)
);

if ($decryptedData === false) {
    throw new Exception('Decryption failed');
}

echo decodeBase64(ParagonIE_Sodium_Compat::bin2hex($decryptedData));

?>