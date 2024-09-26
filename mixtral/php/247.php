<?php

// Define user's original password
$userPassword = 'mysecretpassword';

// Hash the password
$hashedPassword = password_hash($userPassword, PASSWORD_DEFAULT);

// Store $hashedPassword in your database (simulating database storage)
$storedHash = $hashedPassword;

// Define user's entered password
$enteredPassword = 'mysecretpassword';

// To verify a user's entered password against their stored hash
if (password_verify($enteredPassword, $storedHash)) {
    echo 'Passwords match';
} else {
    echo 'Password does not match';
}

?>