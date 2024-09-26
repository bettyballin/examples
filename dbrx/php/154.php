<?php
// Get image path from query string
$imagePath = $_GET['path'] ?? '';

// Validate and sanitize input
if (!is_string($imagePath) || !preg_match('/^\/[\w\-\.]+(\.[\w]{1,4})?$/', $imagePath)) {
    die('Invalid request');
}

// Sanitize the path to prevent directory traversal attacks
$imagePath = realpath(__DIR__ . '/..' . $imagePath);
if (strpos($imagePath, __DIR__) !== 0) {
    die('Forbidden');
}

// Display image content in iframe
header('Content-Type: ' . mime_content_type($imagePath));
readfile($imagePath);

exit;
?>