<?php

$allowedTypes = ['image/jpeg', 'image/png'];

// Check for errors and that it's an actual upload
if ($_FILES['userfile']['error'] === UPLOAD_ERR_OK && $_FILES['userfile']['size'] > 0) {
    // Get the file info
    $finfo = finfo_open(FILEINFO_MIME_TYPE);

    if (!$finfo || !($type = finfo_file($finfo, $_FILES["userfile"]["tmp_name"])))
        throw new RuntimeException("Could not determine MIME type of uploaded file");

    // Check that the mime-type is allowed
    if (!in_array($type, $allowedTypes))
       die('Invalid file type');

   finfo_close($finfo);
}

?>