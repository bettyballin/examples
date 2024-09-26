<?php

$key = 'my_secret_keymy_secret_keymy_secret_keymy_secret_key'; // 32 bytes
$iv = 'my_initialization_vector'; // 16 bytes

$cipher = openssl_encrypt('Hello World!', 'aes-256-cbc', $key, 0, $iv);

echo $cipher;

?>