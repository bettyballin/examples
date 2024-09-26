<?php

$keypair = openssl_pkey_new();

openssl_pkey_export($keypair, $privateKey);
openssl_pkey_export($keypair, $publicKey, null, $config = array('openssl.conf' => '/usr/lib/ssl/openssl.cnf'), $type = OPENSSL_KEYTYPE_RSA);

file_put_contents('pubKey.pem', $publicKey);

$publicKey = openssl_pkey_get_public(file_get_contents("pubKey.pem"));

?>