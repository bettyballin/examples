<?php
$config = array(
   "digest_alg" => "sha512",
   "private_key_bits" => 4096,
   "private_key_type" => OPENSSL_KEYTYPE_RSA,
);
$keys = openssl_pkey_new($config);
$priv = openssl_pkey_get_private($keys);
openssl_pkey_export_to_file($priv, 'private.pem');
?>