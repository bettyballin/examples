<?php

function decrypt($text, $secretKey, $iv = null) {
    $decipher = mcrypt_module_open('tripledes', '', 'cfb', '');
    mcrypt_generic_init($decipher, $secretKey, $iv);
    $decrypted = mdecrypt_generic($decipher, $text);
    mcrypt_generic_deinit($decipher);
    return $decrypted;
}

$name = "OrjgCsq9EkT2TkCZzDOfW492nXQCNIC0BtVJy1FaaTXv2jXAPqx75kaUJVSG/5MCFXXq";
$decoded = base64_decode($name);
$decodedShorter = substr($decoded, 0, strlen($decoded) - 8);
$iv = substr($decoded, strlen($decoded) - 8);
$key = hex2bin('ffa3b5205582d6ea7de6439ec2bafef46a80810003158922');
echo decrypt($decodedShorter, $key, $iv);

?>