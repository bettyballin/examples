<?php

class PasswordHash {
    public function hash($password) {
        return password_hash($password, PASSWORD_DEFAULT);
    }

    public function verify($password, $hashedPassword) {
        return password_verify($password, $hashedPassword);
    }
}

$password = 'my_secret_password';
$username = 'my_username';

$hash = new PasswordHash();

$hashedPassword = $hash->hash($password);

// Store the hashed password in the database
// For demonstration purposes, we'll use an array
$users = array(
    $username => $hashedPassword
);

// Verify the password
$isValid = $hash->verify($password, $users[$username]);

echo "Hashed Password: $hashedPassword\n";
echo "Is Password Valid? " . ($isValid ? "Yes" : "No") . "\n";

?>