<?php
$uploadDirectory = __DIR__ . '/contact_load/';
$safeFileName = basename($_FILES["file"]["name"]);
if (move_uploaded_file($_FILES["file"]["tmp_name"], $uploadDirectory . $safeFileName)) {
    // ...
}
unlink($uploadDirectory . $safeFileName);
?>