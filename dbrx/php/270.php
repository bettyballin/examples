<?php

// Set the path of your uploads folder (outside web root)
$uploadPath = '/home/user/uploads/';

if (!empty($_GET['file']) && is_file($uploadPath . basename($_GET['file']))) {
    $filePath = $uploadPath . basename($_GET['file']);

    // Send headers to force download
    header('Content-Type: application/octet-stream');
    header('Content-Disposition: attachment; filename="' . basename($filePath) . '"');

    readfile($filePath);
    exit;
} else {
    http_response_code(404);
    echo 'Invalid file';
}