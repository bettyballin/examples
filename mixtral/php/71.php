<?php

// Define variables
$user_has_permission = true; // replace with your permission logic
$path = 'path/to/your/file.txt'; // replace with your file path

// Check user permissions and file existence
if ($user_has_permission && is_file($path)) {
    // Set headers
    header('Content-Type: ' . mime_content_type($path));
    header("Cache-Control: no-store no-cache");

    readfile($path);
} else {
    echo "You do not have permission to access this file.";
}

?>