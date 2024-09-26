<?php
$privateKey = openssl_pkey_get_private("file://path/to/private/key");
$signature = openssl_sign("hello", $privateKey, OPENSSL_PKCS1_PADDING);
openssl_free_key($privateKey);
echo $signature;
?>