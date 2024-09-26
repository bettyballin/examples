
<?php
// Your secret key (should be kept secure!)
$secretKey = 'your_secret_key';

// Your plain text data
$plainText = "This is the data I want to encrypt";

// Encrypt the data
$ivLength = openssl_cipher_iv_length($cipher = 'AES-256-CBC');
$iv = openssl_random_pseudo_bytes($ivLength);
$encryptedData = openssl_encrypt($plainText, $cipher, $secretKey, $options = 0, $iv);

// Encode the encrypted data and IV with Base64 to ensure safe storage or transport
$encodedEncryptedData = base64_encode($encryptedData);
$encodedIV = base64_encode($iv);

// To decrypt the data, you will need the encoded encrypted data, the encoded IV, and the secret key
$encodedEncryptedDataReceived = $encodedEncryptedData;
$encodedIV
