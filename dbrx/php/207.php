<?php
$data = "Your message here";
$signature = "";
$private_key_resource = openssl_pkey_get_private("path/to/private/key");

openssl_sign($data, $signature, $private_key_resource, OPENSSL_ALGO_SHA512);

// Save signature to a file or variable:
file_put_contents('path/to/signature.bin', $signature);
?>