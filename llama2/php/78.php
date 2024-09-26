<?php
// Start the session
session_start();

// Check if the user has a valid session ID
if (isset($_COOKIE[session_name()])) {
    // Get the session ID from the cookie
    $session_id = $_COOKIE[session_name()];

    // Print the session ID
    echo "Session ID: $session_id";
} else {
    // If no session ID is found, print an error message
    echo "No valid session ID found.";
}
?>