<?php

// Validate input
if (!isset($_GET['page']) || empty($_GET['page'])) {
    die('Invalid request');
}

$page = $_GET['page'];

// Sanitize the path (optional)
$allowedChars = '/[^a-zA-Z0-9_-]/';
$sanitizedPage = preg_replace($allowedChars, '', $page);

if ($sanitizedPage !== $page) {
    // If sanitized input doesn't match original
    // it means there were unwanted characters.
    die('Invalid request');
}

// Check if the file exists in your subdirectory
$filePath = __DIR__ . '/subdir/' . $sanitizedPage . '.php';

if (!file_exists($filePath)) {
    die('File not found');
}

// Include the file safely (using output buffering)
ob_start();
include $filePath;
$output = ob_get_clean();

echo $output;

?>