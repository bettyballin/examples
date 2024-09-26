<?php
$iv_size = openssl_cipher_iv_length('aes-128-cbc');
$iv = openssl_random_pseudo_bytes($iv_size);
$key = pack('H*', "bcb04b7e103a0cd8b54763051cef08bc55abe029fdebae5e1d417e2ffb2a00a3");
$key_size =  strlen($key);
echo "Key size: " . $key_size . "\n";
$text = "Meet me at 11 o'clock behind the monument.";
echo strlen($text) . "\n";

$crypttext = openssl_encrypt($text, 'aes-128-cbc', $key, OPENSSL_RAW_DATA, $iv);
echo strlen($crypttext) . "\n";
?>