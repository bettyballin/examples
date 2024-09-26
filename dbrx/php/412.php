<?php

$data = 'This is some important data that needs signing.';
$privateKey = base64_decode('Y2E3YjYwYzRjMDRjMjk1ZDQ5ZTQzM2RlMTdjZjVkNGE0NGFjYzJmM2IzOWExNWZhMjViNGE4ZWJiZDBiMDVkYTIwNGU4MWE3ZWZmMTQ0NGE2ZmM2NjExNzRmNTY4M2I0YmYyMTk5YTkyY2UzOWRkZjdmMzhkNTFjYTNmM2Q3ZDU=');

// Generate a new key pair if you don't have one already
if (false === $privateKey) {
    list($publicKey, $privateKey) = sodium_crypto_sign_keypair();
}

$signature = sodium_crypto_sign_detached($data, $privateKey);
$sigBase64 = base64_encode($signature);

echo 'Signature: ' . $sigBase64;