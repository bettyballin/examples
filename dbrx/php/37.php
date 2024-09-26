<?php

// Validate file type and size before processing further
$allowedMimeTypes = ['image/jpeg', 'image/png'];
$fileSizeLimit    = 5 * 1024 * 1024; // Limit upload sizes up to 5MB

if (!in_array($_FILES["file"]['type'], $allowedMimeTypes) || $_FILES["file"]["size"] > $fileSizeLimit) {
    die('Invalid file type or size');
}

// Move uploaded file from temporary location
$uploadDir = '/path/to/secure/upload/directory';
$filename  = basename($_FILES["file"]["name"]);
move_uploaded_file($_FILES["file"]["tmp_name"], "$uploadDir/$filename");

// Read the image content and base64 encode it if needed (e.g for displaying in HTML)
$imageContent   = file_get_contents("$uploadDir/$filename");
$base64Image    = 'data:' . $_FILES['file']['type'] . ';base64,' . base64_encode($imageContent);

// Store $base64Image or encrypted data into the database
// Your database code here...

?>