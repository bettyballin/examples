<?php

$plaintext = 'The secret message in plain text';
$password = '3sc3RLrpd17';
$key = substr(hash('sha256', $password, true), 0, 32);

$iv = openssl_random_pseudo_bytes(16);
$method = "aes-256-xts";
$userName = "JOHN";
$encrypted = base64_encode(openssl_encrypt($plaintext, $method, $key, OPENSSL_RAW_DATA, $iv));

echo "<br>";
var_dump($iv);
echo "<br>";
var_dump($userName);
echo "<br>";
var_dump($encrypted);
echo "<hr>";

$decrypted = openssl_decrypt(base64_decode($encrypted), $method, $key, OPENSSL_RAW_DATA, $iv);
echo 'decrypted to: ' . $decrypted . "\n\n";

?>