<?php
$allowedMimeTypes = ['application/vnd.openxmlformats-officedocument.wordprocessingml.document'];
$fileType = $_FILES['file']['type'];

if (in_array($fileType, $allowedMimeTypes)) {
    // Process file
}
else{
   echo 'Invalid MIME type';
}
?>