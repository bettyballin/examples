<?php
session_start();

define('REQUIRED_CLEARANCE', 1); // Define the required clearance level

if (!isset($_SESSION['logged_in']) || $_SESSION['user']->clearance < REQUIRED_CLEARANCE) {
    header('Location: /login.php');
    exit(); // Add exit() after redirect to prevent further code execution
}

$imagePath = 'path/to/image.jpg'; // Define the image path

// Serve the image
header('Content-Type: image/jpeg'); // Set the content type
readfile($imagePath);
exit();
?>