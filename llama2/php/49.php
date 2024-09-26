<?php
$message = 'Hello world!';
$privateKey = 'path/to/your/private/key';

$signature = openssl_sign($message, $signature, $privateKey, 'sha1WithDsa');

var_dump($signature);
?>