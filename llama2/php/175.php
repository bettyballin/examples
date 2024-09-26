<?php
session_start();

if (!isset($_SESSION['user_id'])) {
    $random_session_id = bin2hex(openssl_random_pseudo_bytes(16));
    $_SESSION['user_id'] = $random_session_id;
    // Save the session ID in the user table
}

// On every page load verify the user's session ID
if (isset($_SESSION['user_id'])) {
    $random_session_id = $_SESSION['user_id'];
    if ($_SESSION['user_id'] === $random_session_id) {
        // Valid user continue with the rest of your application logic
        echo "Valid user!";
    } else {
        // Invalid session ID handle accordingly
        echo "Invalid session ID!";
    }
} else {
    echo "No session ID found!";
}
?>