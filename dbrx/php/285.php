<?php
// Generate salt and pepper (store them securely)
$salt = 'your-salt';
$pepper = 'your-pepper';
$member_id = 123; // replace with actual member id

// Create unique keys for each user by combining member_id with current time hashed using bcrypt algorithm.
$key_ = password_hash($member_id . date('Y-m-d H:i:s') . $salt, PASSWORD_BCRYPT);

// Store the key in your database or session
session_start();
$_SESSION['key'] = $key_;

// Verify link key (assuming you receive 'k' as a GET parameter)
if (isset($_GET['k'])) {
    if (password_verify($_GET['k'], $_SESSION['key'])) {
        // TRUE - Key is valid

        // Remove stored key to prevent reuse
        unset($_SESSION['key']);
        echo "Valid key";
    } else {
        // FALSE - Invalid or expired key
        echo "Invalid key";
    }
} else {
    echo "No key provided";
}