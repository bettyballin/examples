<?php

// Assuming $userPassword and $providedUserPassword are defined
$userPassword = 'your_password';
$providedUserPassword = 'your_password';

// Hash a new password for storing in the database
$hashedPassword = password_hash($userPassword, PASSWORD_DEFAULT);

// Check if provided user's password matches with stored hash
if (password_verify($providedUserPassword, $hashedPassword)) {
    echo 'Password is correct';
} else {
    echo 'Invalid credentials';
}

?>