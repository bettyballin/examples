
<?php
$dataToEncrypt = "This is the data I want to encrypt";
$encryption_key = openssl_random_pseudo_bytes(32); // 256-bit key for AES-256 encryption
$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc')); // Initialization vector

$encryptedData = openssl_encrypt($dataToEncrypt, 'aes-256-cbc', $encryption_key, 0, $iv);
// Now you can store $encryptedData in the database along with the $iv and keep the $encryption_key secure
?>

