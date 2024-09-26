<?php

$nonce = random_bytes(4); // 4-byte nonce
$string = bin2hex(openssl_encrypt($nonce, 'AES-256-ECB', random_bytes(32), OPENSSL_RAW_DATA));

print($string);

?>