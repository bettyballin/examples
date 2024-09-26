<?php

$textToEncrypt = "Hello, World!";
$encryptionMethod = "aes-256-cbc";
$secretHash = "your_secret_hash_here";

$iv_size = openssl_cipher_iv_length($encryptionMethod);
$iv = openssl_random_pseudo_bytes($iv_size);
$encryptedMessage = openssl_encrypt($textToEncrypt, $encryptionMethod, $secretHash, 0, $iv);
$decryptedMessage = openssl_decrypt($encryptedMessage, $encryptionMethod, $secretHash, 0, $iv);

echo "Text to Encrypt: $textToEncrypt\n";
echo "Encrypted Message: $encryptedMessage\n";
echo "Decrypted Message: $decryptedMessage\n";

?>