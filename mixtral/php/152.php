<?php
$filename = $_GET['f'];

// Validate the filename here
if (!preg_match('/^[a-zA-Z0-9\._-]+$/', $filename)) {
    throw new Exception('Invalid filename');
}

if (!file_exists('/path/to/' . $filename)) {
    throw new Exception('File not found');
}

header('Content-Type: ' . mime_content_type('/path/to/' . $filename));
readfile('/path/to/' . $filename);
?>