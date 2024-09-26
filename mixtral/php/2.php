<?php
// User input
$userInput = 'mysecretpassword';

// Hash password
$hashedPassword = password_hash($userInput, PASSWORD_DEFAULT);

// Verify hashed password
$inputFromUser = 'mysecretpassword';
$storedHashedPassword = $hashedPassword;

if (password_verify($inputFromUser, $storedHashedPassword)) {
    echo 'Password is correct';
} else {
    echo 'Invalid credentials';
}