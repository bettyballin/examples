<?php

// Set maximum file size (in bytes)
$maxFileSize = 1000000;

// Set allowed MIME types
$allowedMimeTypes = array('image/jpeg', 'image/png', 'application/pdf');

// Set upload directory
$uploadDir = '/path/to/uploads';

// Validate user input
if (isset($_FILES['file']) && $_FILES['file']['error'] === UPLOAD_ERR_OK) {
    $fileInfo = pathinfo($_FILES['file']['name']);
    if (!in_array($fileInfo['extension'], $allowedMimeTypes)) {
        echo 'Invalid file type.';
        exit;
    }
    if ($_FILES['file']['size'] > $maxFileSize) {
        echo 'File size exceeds the maximum allowed size.';
        exit;
    }
    $uploadPath = $uploadDir . DIRECTORY_SEPARATOR . basename($_FILES['file']['name']);
    if (move_uploaded_file($_FILES['file']['tmp_name'], $uploadPath)) {
        echo 'File uploaded successfully.';
    } else {
        echo 'Error uploading file.';
    }
} else {
    echo 'Invalid file or upload error.';
}