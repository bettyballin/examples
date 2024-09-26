
<?php
// Assuming that $encryptedData is the base64 encoded string you got from .NET
// and $sharedSecret is the same secret you're using in .NET.

// Your encryption settings
$method = 'AES-256-CBC'; // This should match RijndaelManaged's settings
$salt = 'your-salt-string'; // Same as in .NET

// Convert base64 string to binary data
$encryptedData = base64_decode($encryptedData);
$ivSize = openssl_cipher_iv_length($method);

// Extract the IV from the beginning of the encrypted data
$iv = substr($encryptedData, 0, $ivSize);
$
