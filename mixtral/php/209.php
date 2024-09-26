<?php

// Load your private key
$privateKey = openssl_pkey_get_private('file://path/to/your/private-key.pem');

// The data you want to sign
$dataToSign = 'This is the plaintext message';

// Sign the data
openssl_sign($dataToSign, $signature, $privateKey);

// Encode the signature in base64
$encodedSignature = base64_encode($signature);

print($encodedSignature);

?>