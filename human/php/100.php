<?php
$privateKey = file_get_contents('priv.key');
$data = 'hello';
$signature = '';
openssl_sign($data, $signature, $privateKey, OPENSSL_ALGO_SHA1);
$base64EncodedSignature = base64_encode($signature);
echo $base64EncodedSignature;
?>