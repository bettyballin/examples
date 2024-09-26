<?php

if ($_FILES['file']['error'] !== UPLOAD_ERR_OK) {
    die('Error uploading file');
}

$fileType = exif_imagetype($_FILES['file']['tmp_name']);
switch ($fileType) {
    case IMAGETYPE_GIF:
        $imageCreateFunction = 'imagecreatefromgif';
        break;
    case IMAGETYPE_JPEG:
        $imageCreateFunction = 'imagecreatefromjpeg';
        break;
    case IMAGETYPE_PNG:
        $imageCreateFunction = 'imagecreatefrompng';
        break;
    default:
        die('Invalid image format');
}

$imageInfo = getimagesize($_FILES['file']['tmp_name']);
if (!$imageInfo) {
    die('Error getting image size');
}
list($width, $height, $type) = $imageInfo;

// Check file extension and mime type here if needed

$targetPath = '/path/to/secure/directory/' . basename($_FILES['file']['name']);

if (move_uploaded_file($_FILES['file']['tmp_name'], $targetPath)) {
    echo "File uploaded successfully";
} else {
    die('Error moving uploaded file');
}

?>