
<?php

// Define the base directory
$baseDir = __DIR__;

// Fetch the 'dir' GET parameter and sanitize it to prevent directory traversal
$requestDir = realpath($baseDir . '/' . $_GET['dir']);

// Check if the requested directory is within the base directory
if (strpos($requestDir, $baseDir) === 0 && is_dir($requestDir)) {
    // Fetch the files
    $files = scandir($requestDir);

    // Filter out the files you want to list (e.g., only images)
    $imageFiles = array_filter($files, function($file) use ($requestDir) {
        return is_file($requestDir . '/' . $file) && preg_match('/\.(jpg|jpeg|png|gif)$/i', $file);
    });

    // Return the JSON array of image file names
    header('Content-Type: application/json');
    echo json_encode(array_values($
