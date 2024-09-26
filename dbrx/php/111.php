<?php

// Validate that a valid PDF has been requested
if (isset($_GET['file']) && preg_match('/^[a-zA-Z0-9_\\-\\.]+$/', $_GET['file'])) {
    $filePath = '/path/to/your/pdf/files/' . basename($_GET['file']);
} else {
    die('Invalid file request');
}

// Check if the requested PDF exists
if (!is_file($filePath)) {
    die('File not found');
}

// Get and display download count from database or session variable

// Display filesize in MB
$fileSize = round(filesize($filePath) / 1024 / 1024, 2);
echo "File size: {$fileSize}MB<br>";

// Send headers for downloading the file
header('Content-Type: application/pdf');
header("Content-Disposition: attachment; filename=\"" . basename($_GET['file']) . "\"");
readfile($filePath);

?>