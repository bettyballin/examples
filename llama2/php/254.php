<?php

// Define a salt for hashing
$salt = '$2y$10$my_secret_salt$';

// Function to encrypt passwords
function password_encrypt($password) {
    global $salt;
    // Generate a hash using the crypt function
    $hashed_password = crypt($password, $salt);

    return $hashed_password;
}

// Function to check if a password is correct
function password_check($password, $stored_hash) {
    global $salt;
    // Generate a hash using the same salt as before
    $hashed_password = crypt($password, $salt);

    // Compare the generated hash with the stored hash
    if ($hashed_password === $stored_hash) {
        return true;
    } else {
        return false;
    }
}

// Example usage:
$password = "mysecretpassword";
$hashed_password = password_encrypt($password);
echo "Hashed password: " . $hashed_password . "\n";

$check_password = password_check($password, $hashed_password);
echo "Password is correct: " . ($check_password ? 'true' : 'false') . "\n";

?>