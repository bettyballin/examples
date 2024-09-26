<?php
$allowedMimeTypes = ['image/jpeg', 'image/png'];
$fileInfo = finfo_open(FILEINFO_MIME_TYPE);
$mimeType = finfo_file($fileInfo, $_FILES['image']['tmp_name']);
if (!in_array($mimeType, $allowedMimeTypes)) {
    echo "Error: Invalid file type";
    exit;
}
list($width, $height) = getimagesize($_FILES['image']['tmp_name']);
if ($width > 5000 || $height > 5000) {
    echo "Error: Image dimensions exceed the maximum allowed size";
    exit;
}
?>