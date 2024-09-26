<?php
$KEY = "your_secret_key_here"; // replace with your secret key
$data = "your_data_to_encrypt_here"; // replace with your data to encrypt
$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length("aes-256-cbc"));

$ciphertext = openssl_encrypt($data, "aes-256-cbc", $KEY, OPENSSL_RAW_DATA, $iv);
$DATA = base64_encode($iv.$ciphertext);

print($DATA);
?>