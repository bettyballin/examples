<?php

use League\Flysystem\Filesystem;
use League\Flysystem\Adapter\Local;

$adapter = new Local(__DIR__.'/path/to/root');
$filesystem = new Filesystem($adapter);

// Check if file is an image and has the correct format.
if (!in_array(pathinfo($_FILES['photo']['name'], PATHINFO_EXTENSION), ['jpg', 'jpeg', 'png'])) {
    echo "Invalid file type.";
    exit;
}

// Generate a unique filename to avoid duplicates.
$filename = uniqid() . '.' . pathinfo($_FILES['photo']['name'], PATHINFO_EXTENSION);

// Check if the uploaded image is smaller than 350kb (or whatever limit you prefer).
if ($_FILES['photo']['size'] > 1024 * 300) {
    echo "File too large.";
    exit;
}

try {
    // Upload file using Flysystem.
    $filesystem->write($filename, file_get_contents($_FILES['photo']['tmp_name']));
} catch (Exception $e) {
    echo "Error uploading file: {$e->getMessage()}";
}