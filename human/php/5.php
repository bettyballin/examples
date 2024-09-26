<?php

$highScore = "high-score";
$key = openssl_random_pseudo_bytes(16); // 128-bit key

$encrypted = openssl_encrypt($highScore, 'AES-128-ECB', $key, 0);
$hashed = sha1($highScore, true);
$aes = openssl_encrypt($hashed, 'AES-128-ECB', $key, 0);
$hexEncoded = bin2hex($aes);

print($hexEncoded);

?>