<?php

$privKey = openssl_pkey_new(array(
    "private_key_bits" => 2048,
    "private_key_type" => OPENSSL_KEYTYPE_RSA,
));

openssl_pkey_export($privKey, $pkey);

$signature = '';
openssl_sign('hello', $signature, $privKey, OPENSSL_ALGO_SHA256);

echo base64_encode($signature);

?>