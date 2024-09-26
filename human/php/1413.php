<?php

$encryptedHex = 'your_encrypted_hex_string_here';

// Hex decode
$encrypted = sodium_hex2bin($encryptedHex);

// Decrypt
$nonce = "0123456789abcdefghijvbnm";
$key = "827ccb0eea8a706c4c34a16891f84e7b";
$decrypted = sodium_crypto_secretbox_open($encrypted, $nonce, $key);

// Convert to JavaScript object
$decryptedJSON = json_decode($decrypted);
echo "Zip:            " . $decryptedJSON->zip . "\n";
echo "Account number: " . $decryptedJSON->account_number . "\n";
echo "Passcode:       " . $decryptedJSON->passcode . "\n";
echo "Account type:   " . $decryptedJSON->account_type . "\n";
echo "Request:        " . $decryptedJSON->request . "\n";
echo "Device:         " . $decryptedJSON->device . "\n";

?>