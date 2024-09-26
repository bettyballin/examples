<?php
$pass = "test";
$salt = openssl_random_pseudo_bytes(32); // generate a 32-byte random salt
$hashed_pass = hash('sha512', $pass . $salt, true);
echo bin2hex($hashed_pass);
?>