<?php

$password = 'your_password_here';
$hash = password_hash($password, PASSWORD_DEFAULT);

echo "Hash: $hash\n";

$input_password = 'your_input_password_here';
$existing_hash = $hash;

if (password_verify($input_password, $existing_hash)) {
    echo "Password is correct.\n";
} else {
    echo "Incorrect password.\n";
}