<?php

// Load your public key
$publicKey = openssl_pkey_get_public('file://path/to/your/public-key.pem');

// Set the data to sign and the encoded signature
$dataToSign = 'Your data to sign';
$encodedSignature = 'Your base64 encoded signature';

// Decode the base64 encoded signature
$decodedSignature = base64_decode($encodedSignature);

// Verify that the data matches with the provided public key
if (openssl_verify($dataToSign, $decodedSignature, $publicKey)) {
    echo 'The data is valid!';
} else {
    echo 'Invalid signature. The data has been tampered with or it was signed by a different private key.';
}

?>