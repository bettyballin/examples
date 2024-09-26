<?php
$key = file_get_contents('priv.key');
$data = 'hello';
$digest = hash('sha1', $data, true);
$encrypted = openssl_private_encrypt($digest, $encrypted, $key, OPENSSL_PKCS1_PADDING);
$base64 = base64_encode($encrypted);
echo $base64;
?>