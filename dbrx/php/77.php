<?php 
// Start the session
session_start();

// Check if the user is logged in and has admin role
if(!isset($_SESSION['username']) || $_SESSION['role'] != 'admin') {
    // Redirect to login page if not logged in or not admin
    header('Location: login.php');
    exit; // Add exit to prevent further execution
}
?>

<!-- Rest of your HTML/PHP code -->