<?php
$creditCardNumber = "1234567890";
$key = openssl_random_pseudo_bytes(32);
$iv = openssl_random_pseudo_bytes(16);

$encryptedCreditCardNumber = openssl_encrypt($creditCardNumber, "aes-256-cbc", $key, 0, $iv);

echo $encryptedCreditCardNumber;
?>