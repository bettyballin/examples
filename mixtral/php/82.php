<?php
require 'path/to/PasswordCompat/lib/password.php';

function generateHash($password) {
    return password_hash($password, PASSWORD_BCRYPT);
}

// Example usage:
$password = 'mysecretpassword';
$hash = generateHash($password);
echo "Generated Hash: $hash\n";

// To verify a hash
$existingHash = $hash;
$enteredUserInput = 'mysecretpassword';

if (password_verify($enteredUserInput, $existingHash)) {
    echo "Password is correct\n";
} else {
    echo "Invalid credentials\n";
}
?>