<?php

$config = array(
    "digest_alg" => "sha512",
    "private_key_bits" => 4096,
    "private_key_type" => OPENSSL_KEYTYPE_RSA
);

$resource = openssl_pkey_new($config);

print_r($resource);

?>