<?php

$text = "Hello, World!";
$encryption_key = openssl_random_pseudo_bytes(32);
$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('AES-256-CBC'));
$cryptedid = openssl_encrypt($text, 'AES-256-CBC', $encryption_key, 0, $iv);

print($cryptedid);

?>