<?php

$file = 'folder/subfolder/' . $_GET['id'];

// Resolve realpath
if (!($resolved_path = realpath($file))) {
    http_response_code(404);
    echo "Invalid path";
    exit;
}

// Check if resolved path is within expected directory
if (strpos($resolved_path, dirname(__FILE__) . '/folder/subfolder') !== 0) {
    http_response_code(403);
    echo "Path not allowed";
    exit;
}

readfile($resolved_path);

?>