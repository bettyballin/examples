<?php
$secretHash = 'your_secret_hash';
$encryptionMethod = 'AES-128-CBC';
$data = 'your_encrypted_data';

$iv_size = openssl_cipher_iv_length($encryptionMethod);
$iv = substr($data, 0, $iv_size);
$decryptedMessage = openssl_decrypt(substr($data, $iv_size), $encryptionMethod, $secretHash, 0, $iv);

echo $decryptedMessage;
?>