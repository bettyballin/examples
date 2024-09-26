<?php
$pass = "test";

// Generate random 32 character long string as a salt
$salt = bin2hex(random_bytes(16));

// Hash with MD5
$md5_hash = md5($pass . $salt);

// Hash with SHA-512
$sha512_hash = hash('sha512', $pass . $salt);

echo "MD5: {$md5_hash}\n";
echo "SHA-512: {$sha512_hash}";
?>