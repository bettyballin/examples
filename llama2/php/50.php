<?php

$pass = "***";
$salt = bin2hex(random_bytes(16));
$hash = argon2_hash($pass, $salt, 16);

print($hash);

?>