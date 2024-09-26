<?php

$data = file_get_contents('encrypt.txt');
$jsonData = json_decode($data);

$decryptedString = openssl_decrypt(
    base64_decode($jsonData->data),
    'aes-256-cbc',
    base64_decode($jsonData->key),
    OPENSSL_RAW_DATA,
    base64_decode($jsonData->iv)
);

echo "Decrypted String: <br>";
var_dump($decryptedString);
?>