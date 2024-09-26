<?php

$user_input = 'your_password_here';
$existing_stored_hash = 'your_existing_hash_here';

$options = [
    'cost' => 12 // This is default value you can increase it for more security
];

// Hash the password
$hashed_password = password_hash($user_input, PASSWORD_BCRYPT, $options);

// Verify a hash
if (password_verify($user_input, $existing_stored_hash)) {
    echo "Password is valid";
} else {
   echo "Invalid";
}