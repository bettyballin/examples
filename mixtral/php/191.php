<?php

$key = 'your_secure_key';
$iv = 'your_initialization_vector'; // Replace with IV from database
$encryptedData = 'your_encrypted_data'; // Replace with encrypted data

$originalData = openssl_decrypt($encryptedData, 'AES-256-CBC', $key, 0, $iv);

print($originalData);

?>