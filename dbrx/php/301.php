<?php
session_start();

function is_authorized_user($connection, $user_id) {
    // Assuming this function is defined elsewhere in your code
    // For demonstration purposes, it always returns true
    return true;
}

$connection = null; // Replace with your actual database connection

if (isset($_SESSION['user_id']) && is_authorized_user($connection, $_SESSION['user_id'])) {
    // Proceed with deletion...
    echo "User is authorized, proceeding with deletion...";
} else {
    echo "User is not authorized.";
}
?>