<?php

$filename = $_GET["filename"];

// Ensure $filename only contains alphanumeric characters dashes or underscores
if (!preg_match('/^[\w-]+$/', $filename)) {
    die("Invalid filename");
}

// Use realpath() to get the absolute pathname
$filePath = "/path_to_files/" . basename($filename);

// Check if file exists and is readable
if (!is_readable(realpath($filePath))) {
    die("File not found or not accessible");
}

$content = file_get_contents($filePath);

?>