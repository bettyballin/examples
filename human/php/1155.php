<?php
$privateKey = openssl_pkey_get_private($private_key);
openssl_private_decrypt(base64_decode($envelope), $theKey, $privateKey, OPENSSL_PKCS1_PADDING);
?>