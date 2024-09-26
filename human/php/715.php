<?php
$token = bin2hex(openssl_random_pseudo_bytes(16));
print($token."\n");

$token = bin2hex(random_bytes(16));
print($token."\n");
?>