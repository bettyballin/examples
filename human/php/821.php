<?php
// Start session
session_start();

// Check if user is logged in
if (!isset($_SESSION['logged_in'])) {
    // Exit if not logged in
    exit();
}

// Get picture file path from DB
$file_path = "this/path/will/be/from/db/user_xyz.jpg";

// Set mime type respective to file type
header("Content-Type: image/jpeg");

// Read and output the file
readfile($file_path);

// Exit script
die();
?>