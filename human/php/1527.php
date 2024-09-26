<?php
$private_key = 'your_private_key_here'; // replace with your private key
$binary_private_key = hex2bin(base64_decode($private_key));
$message = "Hello!";
$signature = sodium_crypto_sign_detached($message, $binary_private_key);

echo bin2hex($signature);
?>