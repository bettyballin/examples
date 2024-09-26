
<?php
// The original string
$originalString = 'hello world!';
// The encryption key
$key = 'ABCD1234';
// A random initialization vector (IV) is necessary for the chosen cipher
// For AES-256-CBC, the IV length should be 16 bytes
$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));

// Encrypt the string
$encryptedString = openssl_encrypt($originalString, 'aes-256-cbc', $key, 0, $iv);
// Encoded encryptedString and IV to be able to store them together
$encodedEncryptedString = base64_encode($encryptedString);
$encodedIV = base64_encode($iv);

// Now let's decrypt the string
// Decode the IV and encrypted string
$decodedIV = base64_decode($encodedIV);
$decodedEncryptedString =
