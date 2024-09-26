<?php

// Assuming database connection and functions are set up

function fetch_user_by_id($id) {
    // Fetch user data from database by id
    // Replace with your actual database query
    $user = array('id' => $id, 'password' => md5('oldpassword')); // Replace with actual data
    return $user;
}

function update_user_password($id, $oldHash, $newHash) {
    // Update user password in database
    // Replace with your actual database query
    // For demonstration purposes, just echo the updated hashes
    echo "Updated user $id password: oldHash=$oldHash, newHash=$newHash\n";
}

function password_verify($inputPassword, $storedHash) {
    // Use PHP's built-in password verification function
    return password_verify($inputPassword, $storedHash);
}

function password_hash($password, $algo) {
    // Use PHP's built-in password hashing function
    return password_hash($password, $algo);
}

// Set variables
$id = 1; // Replace with actual user id
$inputPassword = 'oldpassword'; // Replace with actual input password

// Execute code
$user = fetch_user_by_id($id);
$oldHash = $user['password']; // md5 hash
$newHash = password_hash($user['password'], PASSWORD_DEFAULT); // bcrypt or argon2 hash

// Store both hashes in the database
update_user_password($user['id'], $oldHash, $newHash);

// Verify login using both hashes
$loginPassword = password_verify($inputPassword, $oldHash) || password_verify($inputPassword, $newHash);

// If user has migrated to new hash remove old hash from database
if ($loginPassword && $newHash !== null) {
    update_user_password($user['id'], null, $newHash);
}