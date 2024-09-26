<?php
$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));
print($iv);
?>