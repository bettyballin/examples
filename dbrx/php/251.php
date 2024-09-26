<?php
$data = 'data to be signed';
$privateKey = file_get_contents('path/to/private.pem');
openssl_sign($data, $signature, $privateKey);
print($signature);
?>