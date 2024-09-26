<?php

function pemToDer($pem) {
    $begin = "-----BEGIN PUBLIC KEY-----";
    $end   = "-----END PUBLIC KEY-----";

    // Remove headers and footers
    $keyData = substr($pem, strlen($begin), -strlen($end));

    // Replace newlines with spaces
    $keyData = str_replace("\n", "", $keyData);

    return base64_decode($keyData);
}

// Generate a new private key
$res = openssl_pkey_new();

// Get public key as PEM
$pubKeyPem = openssl_pkey_get_public(openssl_pkey_export($res, false));

if ($pubKeyPem === FALSE) {
    // Handle error
    die('Failed to get the public key');
}

// Convert PEM-encoded string to DER
$der = pemToDer(openssl_pkey_get_details($pubKeyPem)["key"]);

// Send der data to client here
echo $der;

?>