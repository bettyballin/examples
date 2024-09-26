<?php

$data = 'This is some important data that needs signing.';
$publicKey = base64_decode('your_base64_encoded_public_key_here'); 
$sigBase64 = 'your_base64_encoded_signature_here';              

$dataBin   = $data;
$signature = base64_decode($sigBase64);

if (sodium_crypto_sign_verify_detached($signature, $dataBin, $publicKey)) {
    echo 'The signature is valid!';
} else {
    echo 'Invalid signature.';
}