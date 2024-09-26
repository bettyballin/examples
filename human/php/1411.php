<?php
use ParagonIE_Sodium_Compat;

$credentials = [
    "zip" => "265",
    "account_number" => "10028979739",
    "passcode" => "1234",
    "account_type" => "personal",
    "request" => "login",
    "device" => "iPhone 11"
];

$data = json_encode($credentials);

$keyUtf8 = "827ccb0eea8a706c4c34a16891f84e7b";
$nonceUtf8 = "0123456789abcdefghijvbnm";

$key = ParagonIE_Sodium_Compat::crypto_secretbox_keygen();
$key = $keyUtf8;
$nonce = $nonceUtf8;
$encrypted = ParagonIE_Sodium_Compat::crypto_secretbox($data, $nonce, $key);

$encryptedHex = bin2hex($encrypted);

echo "Ciphertext (hex):\n" . implode("\n", str_split($encryptedHex, 64));
?>