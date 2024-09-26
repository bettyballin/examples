<?php

$pathToFile = 'path/to/your/file.jpg'; // replace with your file path

$finfo = new finfo(FILEINFO_MIME);
if (false === $mimeType = $finfo->file($pathToFile)) {
    throw new RuntimeException('Could not determine file mimetype.');
}

// Check if the MIME type is allowed
$allowedMimes = ['image/jpeg', 'application/pdf'];
if (!in_array($mimeType, $allowedMimes)) {
   echo 'File type is not allowed.';
} else {
   echo 'File type is allowed.';
}