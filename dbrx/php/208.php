<?php

$data = "Your message here";
$private_key_resource = openssl_pkey_new(array(
    "private_key_bits" => 2048,
    "private_key_type" => OPENSSL_KEYTYPE_RSA,
));

$publicKeyPem = openssl_pkey_get_details($private_key_resource)['key'];

openssl_sign($data, $signature, $private_key_resource, OPENSSL_ALGO_SHA512);

if (openssl_verify($data, $signature, $publicKeyPem, OPENSSL_ALGO_SHA512)) {
    echo "Signature is valid.";
} else {
    echo "Invalid signature!";
}

?>