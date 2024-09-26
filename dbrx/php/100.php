<?php

// Hashing a new password:
$password = 'plaintext_password';
$salt = substr(str_shuffle(str_repeat("0123456789abcdefghijklmnopqrstuvwxyz", 22)), 0, 22);
$hash = crypt($password, '$2y$10$' . $salt);

echo "Hash: $hash\n";

// Verifying existing hashed password with plaintext input: 
$input_password = 'plaintext_password';
if (crypt($input_password, $hash) == $hash) {
    echo "Password is correct.\n";
} else {
    echo "Password does not match the stored hash.\n";
}