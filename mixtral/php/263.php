<?php

// Generate RSA key pair
$res = openssl_pkey_new(array('private_key_bits' => 2048));

// Extract the private and public keys
openssl_pkey_export($res, $privKey);

// Replace 'yourBase64EncodedCyperText' with your actual base64 encoded ciphertext
$cypherText = base64_decode('yourBase64EncodedCyperText');

// Import the private key
$privateKey = openssl_pkey_get_private($privKey);

// Decrypt data
openssl_private_decrypt($cypherText, $plaintext, $privateKey);

echo "Decrypted text: $plaintext";

?>