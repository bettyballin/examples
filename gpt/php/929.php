
<?php

// The data to decrypt
$encryptedData = $_GET['data']; // In production, you should validate this input

// The key and IV must match those that were used to encrypt the data.
$key = hex2bin('B374A26A71490437AA024E4FADD5B497FDFF1A8EA6FF12F6FB65AF2720B59CCF');
$iv = hex2bin('64299685b2cc8da5');

// Base64 decode the data before decrypting
$encryptedData = base64_decode($encryptedData);

// Decrypt the data using the same algorithm and mode
$decrypted = openssl_decrypt($encryptedData, 'aes-256-cbc', $key, OPENSSL_RAW_DATA, $
