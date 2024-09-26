<?php

$options = [
    'cost' => 12
];

$password = '<PASSWORD>';
$salt = bin2hex(random_bytes(16)); // Generate a random salt

$hash = password_hash($password, PASSWORD_BCRYPT, $options);

// Store the hash and generated salt in your database for future verification.

echo "Hash: $hash\n";
echo "Salt: $salt\n";

?>