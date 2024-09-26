<?php
$password = 'my_secret_password';

// Use the same hashing algorithm and iteration count as the Java code
$hash = hash_pbkdf2('sha256', $password, '', 1000, 32, true);
$hash = bin2hex($hash);

echo "PHP Result: " . $hash;
?>