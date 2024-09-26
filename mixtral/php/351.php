<?php
session_start();

// Set the upload directory
$uploadDir = 'upload/' . $_SESSION['user_id'];

// Create the upload directory if it doesn't exist
if (!file_exists($uploadDir)) {
    mkdir($uploadDir, 0755);
}

// Rest of the upload script...
?>