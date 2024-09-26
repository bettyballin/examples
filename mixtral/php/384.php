<?php
$dir = basename($_GET['dir']);

// Validate input
if (!is_string($dir) || empty(trim($dir))) {
    die('Invalid directory');
}

// Create absolute path
$absPath = realpath(__DIR__ . '/' . $dir);

// Check if it exists and is a valid folder
if (!$absPath || !is_dir($absPath)) {
    die("Directory not found");
}

// Whitelist check
$allowedDirs = ['art', 'gallery']; // Add your allowed directories here

if (!in_array($dir, $allowedDirs)) {
   die('Access denied');
}

// Fetch files and return JSON
$files = scandir($absPath);
header('Content-Type: application/json');
echo json_encode($files);
?>