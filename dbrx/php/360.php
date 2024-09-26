<?php

$secretKey = random_bytes(SODIUM_CRYPTO_SECRETBOX_KEYBYTES);
$message = 'This is a sensitive message';

// Encrypt the $message using sodium_crypto_secretbox()
$ciphertext = sodium_crypto_secretbox($message, $secretKey);

// Decrypting back to plaintext
$plaintext = sodium_crypto_secretbox_open($ciphertext, $secretKey);

// Printing the output
echo "Original Message: $message\n";
echo "Encrypted Message: " . bin2hex($ciphertext) . "\n";
echo "Decrypted Message: $plaintext\n";

?>