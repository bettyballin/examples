<?php

$key = "test\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0";
$iv = "aaaaaaaaaaaaaaaa";
$ciphertextHex = "3771e837685ff5d4173801900de6e14c";

$ciphertext = hex2bin($ciphertextHex);

function AES_decrypt($ciphertext, $key, $iv) {
    $decrypted = openssl_decrypt($ciphertext, 'aes-128-cbc', $key, OPENSSL_RAW_DATA, $iv);
    return $decrypted;
}

$decrypted = AES_decrypt($ciphertext, $key, $iv);

$paddingLength = ord($decrypted[strlen($decrypted) - 1]);
$decrypted = substr($decrypted, 0, -$paddingLength);

echo $decrypted;

?>