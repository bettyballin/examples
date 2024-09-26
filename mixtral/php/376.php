<?php

use Illuminate\Encryption\Encrypter;

$crypt = new Encrypter('your_secret_key', 'AES-256-CBC');

// Encryption
$encryptedData = $crypt->encrypt('your secret data');

// Decryption
$decryptedData = $crypt->decrypt($encryptedData);

print($encryptedData . "\n");
print($decryptedData . "\n");

?>