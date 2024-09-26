<?php

$iv = openssl_random_pseudo_bytes(16);
$hex_iv = bin2hex($iv);

// Now $hex_iv is a hexadecimal string representing the random bytes.
print($hex_iv);

?>