<?php

$resource = openssl_pkey_new(array(
    "private_key_bits" => 2048,
    "private_key_type" => OPENSSL_KEYTYPE_RSA,
));

// Method 1: Export to file
openssl_pkey_export_to_file($resource, 'path/to/private.key');

// Method 2: Export to string
$privKeyPem = null;
openssl_pkey_export($resource, $privKeyPem);
echo $privKeyPem;

?>