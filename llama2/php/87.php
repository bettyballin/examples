<?php

$username = trim(openssl_encrypt('my_username', 'aes-256-cbc', 'password'));
$password = trim(openssl_encrypt('my_password', 'aes-256-cbc', 'password'));

print($username . "\n");
print($password . "\n");

?>